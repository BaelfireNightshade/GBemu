public class InternalRAM
{
	private static int[] ram = new int[(0xE000 - 0xC000)]; //Normal internal RAM
	private static int[] highRam = new int[(0xFFFF - 0xFF80)]; //High RAM

	public static void reset()
	{
		ram = new int[(0xE000 - 0xC000)]; //Normal internal RAM
		highRam = new int[(0xFFFF - 0xFF80)]; //High RAM
	}

	public static int read(int address)
	{
		int data;

		if(address < 0xE000)
		{
			data = ram[address - 0xC000];
		}
		else if(address < 0xFE00)
		{
			data = ram[address - 0xE000];
		}
		else
		{
			data = highRam[address - 0xFF80];
		}

		// if(address == 0xFF85 & data == 0x01)
		// {
		// 	System.out.printf("reading from address 0xFF85 data = 0x01\n");
		// }

		return data;
	}

	public static void write(int address, int data)
	{
		if(address < 0xE000)
		{
			ram[address - 0xC000] = (data & 0xFF);
		}
		else if(address < 0xFE00)
		{
			ram[address - 0xE000] = (data & 0xFF);
		}
		else
		{
			highRam[address - 0xFF80] = (data & 0xFF);
		}
	}
}
