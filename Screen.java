/*

What needs to happen:

*/

import javax.swing.JPanel;
import java.awt.*;

import java.util.Timer;
import java.util.TimerTask;

public class Screen extends JPanel
{
	private int[][] screen;

	private Color color0 = Color.white;
	private Color color1 = new Color(173, 173, 173);//Light grey
	private Color color2 = new Color(99, 99, 99);//Dark grey
	private Color color3 = Color.black;

	public final int SCREEN_SIZE_X = 160;
	public final int SCREEN_SIZE_Y = 144;

	private int nextClock = 0;

	private long lastTime;

	public int scale = 4;

	private Timer screenTimer;

	public Screen()
	{
		setBackground(color0);
		setPreferredSize(new Dimension(SCREEN_SIZE_X * scale, SCREEN_SIZE_Y * scale));
		screen = new int[SCREEN_SIZE_X][SCREEN_SIZE_Y];

		screenTimer = new Timer();
		screenTimer.schedule(new ScreenTimer(this), 0, 9);
	}

	public void paintComponent(Graphics page)
	{
		draw(page);
	}

	class ScreenTimer extends TimerTask
	{
		private Screen timerScreen;

		public ScreenTimer(Screen newScreen)
		{
			timerScreen = newScreen;
		}

		public void run()
		{
			timerScreen.update();
		}
	}

	public void update()
	{
		while((nextClock <= CPU.clock) && ((IO.LCDC & 0x80) == 0x80))
		{
			//System.out.printf("\nDEBUG: IO.LY=%d\n", IO.LY);
			int mode = (IO.STAT & 0x03);

			switch(mode)
			{
				case 0:
					if(IO.LY == 144)
					{
						IO.STAT = (IO.STAT & 0xFC) | 0x1;
					}
					else
					{
						IO.STAT = (IO.STAT & 0xFC) | 0x2;
					}
				break;
				case 1:
					if(IO.LY == 0)
					{
						IO.STAT = (IO.STAT & 0xFC) | 0x2;
					}
				break;
				case 2:
					IO.STAT = (IO.STAT & 0xFC) | 0x3;
				break;
				case 3:
					IO.STAT = (IO.STAT & 0xFC) | 0x0;
				break;
				default:
					System.out.println("\nDEBUG: Something went wrong with the Screen Controller. Mode " + mode + ".");
				break;
			}

			mode = (IO.STAT & 0x03);
			//System.out.printf("\nDEBUG: LY=%03d Mode=%d", IO.LY, mode);

			switch(mode)
			{
				case 0: //H-blank
					//update current scanline
					IO.LY += 1;
					checkLCDStatInterrupts();
					nextClock += 204;
				break;
				case 1: //V-blank
					IO.LY += 1;

					if(IO.LY == 154)
					{
						IO.LY = 0;
					}
					checkLCDStatInterrupts();
					if(IO.LY == 145)
					{
						IO.IF = IO.IF | 0x01;
						repaint();

						/*long currentTime = System.nanoTime();
						double fps = 1000000000.0 / (currentTime - lastTime);
						lastTime = currentTime;
						System.out.println("fps: " + fps);//*/
					}
					nextClock += 456;
				break;
				case 2: //Searching OAM-RAM
					checkLCDStatInterrupts();
					nextClock += 80;
				break;
				case 3: //Transfering Data to LCD Driver
					scanline();
					nextClock += 172;
				break;
				default:
					System.out.println("\nDEBUG: Something went wrong with the Screen Controller. Mode " + mode + ".");
				break;
			}

		}
	}

	public void scanline()
	{


		int currentBgLine = (IO.LY + IO.SCY) % 256;

		//background
		if((IO.LCDC & 0x01) == 0x01)
		{
			int baseBgMapAddress;
			if((IO.LCDC & 0x08) == 0x08)
			{
				baseBgMapAddress = 0x9C00;
			}
			else
			{
				baseBgMapAddress = 0x9800;
			}
			int [] fullBgLine = new int[256];

			//fill the current line of background
			for(int currentTile = 0; currentTile < 32; currentTile++)
			{
				int tileIndex = Memory.read(baseBgMapAddress + (((currentBgLine / 8) * 0x20) + currentTile));

				int tileAddress = bgWinTileAddress(tileIndex);
				//which line in tile
				int tileLine = currentBgLine % 8;
				//Interlace bits
				int tilePart1 = Memory.read(tileAddress + (tileLine * 2) + 1);
				int tilePart2 = Memory.read(tileAddress + (tileLine * 2));
				//System.out.printf("TP1: 0x%04X TP2: 0x%04X\n", tilePart1, tilePart2);
				int lineOfPixels = BitTwiddling.interleave(tilePart1, tilePart2);

				//fill the current line of the current tile
				for(int pixel = 0; pixel < 8; pixel++)
				{
					fullBgLine[((currentTile * 8) + (7 - pixel))] = (lineOfPixels >> (pixel * 2)) & 0x3;
				}
			}

			//set up bg color palette
			int [] bgPallet = new int[4];
			for(int x = 0; x < 4; x++)
			{
				bgPallet[x] = (IO.BGP >> (x * 2)) & 0x3;
			}

			//copy bg to screen
			if(IO.LY < 144)
			{
				for(int pixel = 0; pixel < SCREEN_SIZE_X; pixel++)
				{
					screen[pixel][IO.LY] = bgPallet[fullBgLine[((pixel + IO.SCX) % 256)]];
				}
			}
			else
			{
				System.out.println("DEBUG: Tried writing to the screen space during V-Sync. Out of bounds.\n\n");
			}
		}
	}

	public void draw(Graphics g)
	{
		Color c;
		for(int x = 0; x < screen.length; x++)
		{
			for(int y = 0; y < screen[0].length; y++)
			{
				switch(screen[x][y])
				{
					case 0:
						c = color0;
						break;
					case 1:
						c = color1;
						break;
					case 2:
						c = color2;
						break;
					case 3:
						c = color3;
						break;
					default:
						c = color0;
				}//end of color switch
				drawPixel(x, y, c, g);
			}//end of y loop
		}//end of x loop
	}//end of draw()

	private void drawPixel(int x, int y, Color c, Graphics g)
	{
		g.setColor(c);
		g.fillRect(x * scale, y * scale, scale, scale);
	}

	public void screenBlank()
	{
		screen = new int[160][144];
		repaint();
	}

	public int bgWinTileAddress(int tileIndex)
	{
		int address = 0;
		if((IO.LCDC & 0x10) == 0x10)
		{
			address = 0x8000 + (tileIndex * 0x10);
		}
		else
		{
			address = 0x8800 + (((tileIndex ^ 0x80) * 0x10) * 16);
		}
		return (address & 0xFFFF);
	}

	public void checkLCDStatInterrupts()
	{
		if((IO.STAT & 0x40) == 0x40)
		{
			//check to see if LYC == LY
			if(IO.LY == IO.LYC)
			{
				//set STAT interrupt
			}
		}
		else if((IO.STAT & 0x20) == 0x20)
		{
			//check to see if mode 2(Searching OAM)
			int mode = (IO.STAT & 0x03);
			if(mode == 2)
			{
				//set STAT interrupt
				IO.IF = IO.IF | 0x02;
			}
		}
		else if((IO.STAT & 0x10) == 0x10)
		{
			//check to see if mode 1(V-blank)
			int mode = (IO.STAT & 0x03);
			if(mode == 1)
			{
				//set STAT interrupt
				IO.IF = IO.IF | 0x02;
			}
		}
		else if((IO.STAT & 0x08) == 0x08)
		{
			//check to see if mode 0(H-blank)
			int mode = (IO.STAT & 0x03);
			if(mode == 0)
			{
				//set STAT interrupt
				IO.IF = IO.IF | 0x02;
			}
		}
	}

	public void loadTile(int xOff, int yOff, int[][] tile)
	{
		for(int x = 0; x < tile.length; x++)
		{
			for(int y = 0; y < tile[0].length; y++)
			{
				int pixelX = x + xOff;
				int pixelY = y + yOff;
				if(!((pixelX < 0) || (pixelX > 159) || (pixelY < 0) || (pixelY > 143)))//make sure we don't address non-existant screen space.
				{
					screen[x + xOff][y + yOff] = tile[x][y];
				}
			}
		}
	}

	//size is either 8 or 16 pixels tall
	public void loadNativeTile(int xOff, int yOff, int address, int size)
	{
		int [][] tile = new int [8][size];
		//de-interlace line using BitTwiddling.interleave(x, y)
		//First byte is y, second is x
		for(int line = 0; line < size; line++)
		{
			int fullLine = BitTwiddling.interleave(Memory.read(address + (line * 2) + 1), Memory.read(address + (line * 2)));
			for(int collum = 0; collum < 8; collum++)
			{
				tile[7 - collum][line] = (fullLine >>> collum * 2) & 0x3;
			}
		}
		loadTile(xOff, yOff, tile);
	}

	public void loadNativeTile(int xOff, int yOff, int [] nativeTile, int size)
	{
		int [][] tile = new int [8][size];
		//de-interlace line using BitTwiddling.interleave(x, y)
		//First byte is y, second is x
		for(int line = 0; line < size; line++)
		{
			int fullLine = BitTwiddling.interleave(nativeTile[(line * 2) + 1], nativeTile[(line * 2)]);
			for(int collum = 0; collum < 8; collum++)
			{
				tile[7 - collum][line] = (fullLine >>> collum * 2) & 0x3;
			}
		}
		loadTile(xOff, yOff, tile);
	}

	public void loadNintendoLogo(int xOff, int yOff)
	{
		int address = 0x0104; //starting address of the Nintendo Logo
		int data;

		for(int yBlock = 0; yBlock < 2; yBlock++)
		{
			for(int xBlock = 0; xBlock < 12; xBlock++)
			{
				int shift = 0x7;
				//fill in each pixel of 4x4 block
				for(int y = 0; y < 4; y++)
				{
					data = Memory.read(address);
					//System.out.printf("0x%02X\n", data);
					for(int x = 0; x < 4; x++)
					{
						int pixel = (data >>> (shift-- & 0x7) & 0x1);
						int xPixel = (xBlock * 4) + x + xOff;
						int yPixel = (yBlock * 4) + y + yOff;

						//System.out.println("X:" + x + ", Y:" + y);

						if(pixel == 1)
						{
							screen[xPixel][yPixel] = 0x3;
						}
						else
						{
							screen[xPixel][yPixel] = 0x0;
						}
					}
					if(y % 2 == 1)
					{
						address++;
					}
				}
			}
		}
	}

	public void testScreen()
	{
		loadTile(0, 0, testTile0);
		loadTile(8, 8, testTile1);

		loadNativeTile(16, 16, nativeTestTile1, 8);
		repaint();
	}

	private int[][] testTile0 = {
		{0,0,0,0,0,0,0,0},
		{0,0,3,3,3,3,3,0},
		{0,3,3,3,3,3,3,0},
		{0,3,0,0,3,0,0,0},
		{0,3,0,0,3,0,0,0},
		{0,3,3,3,3,3,3,0},
		{0,0,3,3,3,3,3,0},
		{0,0,0,0,0,0,0,0}
	};

	private int [][] testTile1 = {
		{0,0,0,0,2,2,2,2},
		{0,0,0,0,2,2,2,2},
		{0,0,0,0,2,2,2,2},
		{0,0,0,0,2,2,2,2},
		{1,1,1,1,3,3,3,3},
		{1,1,1,1,3,3,3,3},
		{1,1,1,1,3,3,3,3},
		{1,1,1,1,3,3,3,3}
	};

	private int [] nativeTestTile1 = {
		0x00, 0x00, 0x7C, 0x7C, 0x66, 0x66, 0x7C, 0x7C, 0x66, 0x66, 0x66, 0x66, 0x7C, 0x7C, 0x00, 0x00
	};
}