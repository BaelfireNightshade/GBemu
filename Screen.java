/*

What needs to happen:
	*Implement screen drawer(possibly here or in VRAM, probably here)

*/

import javax.swing.JPanel;
import java.awt.*;

public class Screen extends JPanel
{
	private int[][] screen;

	private Color color0 = Color.white;
	private Color color1 = new Color(173, 173, 173);//Light grey
	private Color color2 = new Color(99, 99, 99);//Dark grey
	private Color color3 = Color.black;

	public int scale = 4;

	public Screen()
	{
		setBackground(color0);
		setPreferredSize(new Dimension(160 * scale, 144 * scale));
		screen = new int[160][144];
	}

	public void paintComponent(Graphics page)
	{
		draw(page);
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
			int fullLine = BitTwiddling.interleave(Cartridge.read(address + (line * 2) + 1), Cartridge.read(address + (line * 2)));
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
					data = Cartridge.read(address);
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