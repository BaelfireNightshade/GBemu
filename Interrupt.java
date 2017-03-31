public class Interrupt
{
	private static int interruptEnable;

	public static boolean IME = false; //Interrupt Master Enable Flag

	public static void reset()
	{
		interruptEnable = 0x00;
		IME = false;
	}

	public static int read()
	{
		return (interruptEnable & 0xFF);
	}

	public static void write(int data)
	{
		interruptEnable = data & 0xFF;
	}

	public static boolean checkForInterrupts()
	{
		boolean result = false;
		if(IME)
		{
			int interruptResult = (IO.IF & interruptEnable & 0x1F);
			if(interruptResult != 0x00)
			{
				Instruction.push_PC();
				if((interruptResult & 0x01) == 0x01)
				{
					Register.writePC(0x0040);//V-Blank
					IO.IF = IO.IF & 0xFE;
				}
				else if((interruptResult & 0x02) == 0x02)
				{
					Register.writePC(0x0048);//LCD STAT
					IO.IF = IO.IF & 0xFD;
				}
				else if((interruptResult & 0x04) == 0x04)
				{
					Register.writePC(0x0050);//Timer
					IO.IF = IO.IF & 0xFB;
				}
				else if((interruptResult & 0x08) == 0x08)
				{
					Register.writePC(0x0058);//Serial
					IO.IF = IO.IF & 0xF7;
				}
				else if((interruptResult & 0x10) == 0x10)
				{
					Register.writePC(0x0060);//Joypad
					IO.IF = IO.IF & 0xEF;
				}
				IME = false;
				result = true;
			}
		}
		return result;
	}
}