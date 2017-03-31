public class SpriteAttribMemory
{
	private static int [] memory = new int[(0xFEA0 - 0xFE00)];

	public static void reset()
	{
		memory = new int[(0xFEA0 - 0xFE00)];
	}

	public static int read(int address)
	{
		int data = memory[address - 0xFE00];
		return data;
	}

	public static void write(int address, int data)
	{
		memory[address - 0xFE00] = (data & 0xFF);
	}
}