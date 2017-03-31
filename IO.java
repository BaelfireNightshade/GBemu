/*
	Todo:
		1. DMA
		2. Timer
*/

public class IO
{
	//keypad Registers
	public static int KP_A = 1;
	public static int KP_B = 1;
	public static int KP_Select = 1;
	public static int KP_Start = 1;
	public static int KP_Right = 1;
	public static int KP_Left = 1;
	public static int KP_Up = 1;
	public static int KP_Down = 1;
	public static int P1;

	//LCD Registers
	public static int LCDC = 0x91; //LCD Control Register
	public static int STAT; //LCD Status Register
	public static int SCY = 0x00; //LCD Scroll Y
	public static int SCX = 0x00; //LCD Scroll X
	public static int LY; //LCD Y Coordinate
	public static int LYC = 0x00; //LCD LY compare
	public static int WY = 0x00; //LCD Window Y position
	public static int WX = 0x00; //LCD Window X position (minus 7)
	public static int BGP = 0xFC; //LCD BG Pallet Data
	public static int OBP0 = 0xFF; //LCD Object Palette 0 Data
	public static int OBP1 = 0xFF; //LCD Object Palette 1 Data

	//Interrupt Registers
	public static int IF = 0;

	//DMA
	public static int dma;

	//Timer
	public static int div;
	public static int tac;
	public static int tma;
	public static int tima;


	//Default array for unimplemented IO
	//private static int[] io = new int[(0xFF80 - 0xFF00)];	//Attempted fix for Tetris Licence hang

	public static int read(int address)
	{
		int data = 0xFF;
		switch(address)
		{
			//Keypad
			case 0xFF00:
				data = keypadByte(P1);
			break;

			//LCD
			case 0xFF40:
				data = LCDC;
			break;
			case 0xFF41:
				data = (STAT | 0x80);
			break;
			case 0xFF42:
				data = SCY;
			break;
			case 0xFF43:
				data = SCX;
			break;
			case 0xFF44:
				data = LY;
			break;
			case 0xFF45:
				data = LYC;
			break;
			case 0xFF46:
				data = dma;
			break;
			case 0xFF4A:
				data = WY;
			break;
			case 0xFF4B:
				data = WX;
			break;
			case 0xFF47:
				data = BGP;
			break;
			case 0xFF48:
				data = OBP0;
			break;
			case 0xFF49:
				data = OBP1;
			break;

			//Interrupt
			case 0xFF0F:
				data = IF | 0xE0;
			break;

			default:
				if(address < 0xFF4C)
				{
					System.out.printf("DEBUG: RD unimplemented IO: 0x%04X(%s), PC:0x%04X\n", address, IONames[(address & 0xFF)], Register.readPC());
				}
				else
				{
					System.out.printf("DEBUG: RD unimplemented IO: 0x%04X, PC:0x%04X\n", address, Register.readPC());
				}
				//data = io[address - 0xFF00];	//Attempted fix for Tetris Licence hang
			break;
		}

		return data;
	}

	public static void write(int address, int data)
	{
		switch(address)
		{
			//Keypad
			case 0xFF00:
			P1 = (data & 0xFF);
			break;

			//LCD
			case 0xFF40:
				LCDC = (data & 0xFF);
			break;
			case 0xFF41:
				STAT = (data & 0x78);
			break;
			case 0xFF42:
				SCY = (data & 0xFF);
			break;
			case 0xFF43:
				SCX = (data & 0xFF);
			break;
			case 0xFF44:
				LY = 0x00;
			break;
			case 0xFF45:
				LYC = (data & 0xFF);
			break;
			case 0xFF46:
				dma = (data & 0xFF);
				int startAddress = dma << 8;
				new OAMDMA(startAddress).start();
			break;
			case 0xFF4A:
				WY = (data & 0xFF);
			break;
			case 0xFF4B:
				WX = (data & 0xFF);
			break;
			case 0xFF47:
				BGP = (data & 0xFF);
			break;
			case 0xFF48:
				OBP0 = (data & 0xFF);
			break;
			case 0xFF49:
				OBP1 = (data & 0xFF);
			break;

			//Interrupt
			case 0xFF0F:
				IF = (data & 0x1F);
			break;

			default:
				if(address < 0xFF4C)
				{
					System.out.printf("DEBUG: WR unimplemented IO: 0x%04X(%s), data: 0x%02X, PC: 0x%04X\n", address, IONames[(address & 0xFF)], data, Register.readPC());
				}
				else
				{
					System.out.printf("DEBUG: WR unimplemented IO: 0x%04X, data: 0x%02X, PC: 0x%04X\n", address, data, Register.readPC());
				}
				//io[address - 0xFF00] = (data & 0xFF);		//Attempted fix for Tetris Licence hang
			break;
		}
	}

	private static int keypadByte(int data)
	{
		int result = 0;
		if((data | ~0x10) == ~0x10)
		{
			result = KP_Right | (KP_Left << 1) | (KP_Up << 2) | (KP_Down << 3);
		}
		if((data | ~0x20) == ~0x20)
		{
			result = result | KP_A | (KP_B << 1) | (KP_Select << 2) | (KP_Start << 3);
		}

		return result | (~data & 0xF0);
	}

	private static String [] IONames = {
		"P1 (Joypad)",//00
		"SB (Serial data)",//01
		"SC (Serial Control)",//02
		"",
		"DIV (Divider Reg",//04
		"TIMA (Timer Counter)",//05
		"TMA (Timer Modulo)",//06
		"TAC (Timer Control)",//07
		"",//08
		"",//09
		"",//0a
		"",//0b
		"",//0c
		"",//0d
		"",//0e
		"IF (Interrupt Flag)",//0f
		"NR10 (sound 1)",//10
		"NR11 (sound 1)",//11
		"NR12 (sound 1)",//12
		"NR13 (sound 1)",//13
		"NR14 (sound 1)",//14
		"",//15
		"NR21 (sound 2)",//16
		"NR22 (sound 2)",//17
		"NR23 (sound 2)",//18
		"NR24 (sound 2)",//19
		"NR30 (sound 3)",//1a
		"NR31 (sound 3)",//1b
		"NR32 (sound 3)",//1c
		"NR33 (sound 3)",//1d
		"NR34 (sound 3)",//1e
		"",//1f
		"NR41 (sound 4)",//20
		"NR42 (sound 4)",//21
		"NR43 (sound 4)",//22
		"NR44 (sound 4)",//23
		"NR50 (snd ch ctrl",//24
		"NR51 (snd out)",//25
		"NR52 (snd on/off)",//26
		"",//27
		"",//28
		"",//29
		"",//2a
		"",//2b
		"",//2c
		"",//2d
		"",//2e
		"",//2f
		"Wave Pattern 0",//30
		"Wave Pattern 1",//31
		"Wave Pattern 2",//32
		"Wave Pattern 3",//33
		"Wave Pattern 4",//34
		"Wave Pattern 5",//35
		"Wave Pattern 6",//36
		"Wave Pattern 7",//37
		"Wave Pattern 8",//38
		"Wave Pattern 9",//39
		"Wave Pattern a",//3a
		"Wave Pattern b",//3b
		"Wave Pattern c",//3c
		"Wave Pattern d",//3d
		"Wave Pattern e",//3e
		"Wave Pattern f",//3f
		"LCDC (LCD control)",//40
		"STAT (LCDC status)",//41
		"Scroll Y",//42
		"Scroll X",//43
		"LCD Y pos",//44
		"LCD Y compare",//45
		"DMA address",//46
		"BG/win Palette",//47
		"OBJ Pal 0",//48
		"OBJ Pal 1",//49
		"Window Y",//4a
		"Window X"//4b
	};

}
