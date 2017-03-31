public class VRAM
{
	private static int[] tileData = new int[(0x97FF - 0x8000 + 1)];
	private static int[] bgMap0 = new int [(0x9BFF - 0x9800 + 1)];
	private static int[] bgMap1 = new int [(0x9FFF - 0x9C00 + 1)];

	public static void reset()
	{
		tileData = new int[(0x97FF - 0x8000 + 1)];
		bgMap0 = new int [(0x9BFF - 0x9800 + 1)];
		bgMap1 = new int [(0x9FFF - 0x9C00 + 1)];
	}

	public static int read(int address)
	{
		int data;
		if(address < 0x9800)
		{
			data = tileData[address - 0x8000];
		}
		else if(address < 0x9C00)
		{
			data = bgMap0[address - 0x9800];
		}
		else
		{
			data = bgMap1[address - 0x9C00];
		}

		return (data & 0xFF);
	}

	public static void write(int address, int data)
	{
		if(address < 0x9800)
		{
			tileData[address - 0x8000] = (data & 0xFF);
		}
		else if(address < 0x9C00)
		{
			bgMap0[address - 0x9800] = (data & 0xFF);
		}
		else
		{
			bgMap1[address - 0x9C00] = (data & 0xFF);
		}
	}
}