public class IO
{

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

	public static int read(int address)
	{
		int data = 0xFF;
		switch(address)
		{
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
		}

		return data;
	}

	public static void write(int address, int data)
	{
		switch(address)
		{
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
			break;
			case 0xFF45:
				LYC = (data & 0xFF);
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
		}
	}

}