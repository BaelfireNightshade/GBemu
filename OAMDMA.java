public class OAMDMA extends Thread
{
	private int inAddress;
	private int outAddress;
	private int count;

	public OAMDMA(int startAddress)
	{
		inAddress = startAddress;
		outAddress = 0xFE00;
		count = 40 * 4;
	}

	public void run()
	{
		for(;count > 0;count--)
		{
			//gather data
			int data = Memory.read(inAddress);

			//write data
			Memory.write(outAddress, data);

			//update to next addresses
			inAddress++;
			outAddress++;
		}
	}
}