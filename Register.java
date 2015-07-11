/*

What needs to happen:
	*Create reset for registers?
*/
public class Register
{
	private static int regAF = 0x01B0;
	private static int regBC = 0x0013;
	private static int regDE = 0x00D8;
	private static int regHL = 0x014D;

	private static int regSP = 0xFFFE;
	private static int regPC = 0x0100;

	private static final int zeroFlag = 0b10000000;
	private static final int subtractFlag = 0b01000000;
	private static final int halfCarryFlag = 0b00100000;
	private static final int carryFlag = 0b00010000;


	// R/W for regAF
	public static void writeAF(int data)
	{
		regAF = (data & 0xFFFF);
	}

	public static int readAF()
	{
		return regAF;
	}

	public static void writeA(int data)
	{
		regAF = ((data & 0xFF) << 8) | (regAF & 0xFF);
	}

	public static int readA()
	{
		return ((regAF>>>8) & 0xFF);
	}

	public static void writeF(int data)
	{
		regAF = (data & 0xFF) | (regAF & 0xFF00);
	}

	public static int readF()
	{
		return (regAF & 0xFF);
	}


	// R/W for regBC
	public static void writeBC(int data)
	{
		regBC = (data & 0xFFFF);
	}

	public static int readBC()
	{
		return regBC;
	}

	public static void writeB(int data)
	{
		regBC = ((data & 0xFF) << 8) | (regBC & 0xFF);
	}

	public static int readB()
	{
		return ((regBC>>>8) & 0xFF);
	}

	public static void writeC(int data)
	{
		regBC = (data & 0xFF) | (regBC & 0xFF00);
	}

	public static int readC()
	{
		return (regBC & 0xFF);
	}


	// R/W for regDE
	public static void writeDE(int data)
	{
		regDE = (data & 0xFFFF);
	}

	public static int readDE()
	{
		return regDE;
	}

	public static void writeD(int data)
	{
		regDE = ((data & 0xFF) << 8) | (regDE & 0xFF);
	}

	public static int readD()
	{
		return ((regDE>>>8) & 0xFF);
	}

	public static void writeE(int data)
	{
		regDE = (data & 0xFF) | (regDE & 0xFF00);
	}

	public static int readE()
	{
		return (regDE & 0xFF);
	}


	// R/W for regHL
	public static void writeHL(int data)
	{
		regHL = (data & 0xFFFF);
	}

	public static int readHL()
	{
		return regHL;
	}

	public static void writeH(int data)
	{
		regHL = ((data & 0xFF) << 8) | (regHL & 0xFF);
	}

	public static int readH()
	{
		return ((regHL>>>8) & 0xFF);
	}

	public static void writeL(int data)
	{
		regHL = (data & 0xFF) | (regHL & 0xFF00);
	}

	public static int readL()
	{
		return (regHL & 0xFF);
	}


	// R/W for SP
	public static void writeSP(int data)
	{
		regSP = (data & 0xFFFF);
	}

	public static int readSP()
	{
		return regSP;
	}


	// R/W for PC
	public static void writePC(int data)
	{
		regPC = (data & 0xFFFF);
	}

	public static int readPC()
	{
		return regPC;
	}

	// Increment PC
	public static void incPC(int x)
	{
		regPC = ((regPC + x) & 0xFFFF);
	}


	// set and get zero(z) flag in regF
	public static boolean getZeroFlag()
	{
		return (((readF()>>>7) & 1) != 0);
	}

	public static void setZeroFlag(boolean z)
	{
		int f = readF();
		if(z)
		{
			writeF((f | zeroFlag));
			//System.out.println("DEBUG: Setting Zero Flag from Register.");
		}
		else
		{
			writeF((f & ~zeroFlag));
		}
	}


	// set and get subtraction(N) flag in regF
	public static boolean getSubtFlag()
	{
		return (((readF()>>>6) & 1) != 0);
	}

	public static void setSubtFlag(boolean n)
	{
		int f = readF();
		if(n)
		{
			writeF((f | subtractFlag));
		}
		else
		{
			writeF((f & ~subtractFlag));
		}
	}


	// set and get half carry(H) flag in regF
	public static boolean getHCarryFlag()
	{
		return (((readF()>>>5) & 1) != 0);
	}

	public static void setHCarryFlag(boolean h)
	{
		int f = readF();
		if(h)
		{
			writeF((f | halfCarryFlag));
		}
		else
		{
			writeF((f & ~halfCarryFlag));
		}
	}


	// set and get carry(C) flag in regF
	public static boolean getCarryFlag()
	{
		return (((readF()>>>4) & 1) != 0);
	}

	public static void setCarryFlag(boolean c)
	{
		int f = readF();
		if(c)
		{
			writeF((f | carryFlag));
		}
		else
		{
			writeF((f & ~carryFlag));
		}
	}

	public static void dumpRegisters()
	{
		System.out.println("DEBUG: Dumping Registers to console");
		System.out.printf("\n\trA: 0x%02X\n", Register.readA());
		System.out.printf("\trF: 0x%02X\n", Register.readF());
		System.out.printf("\trB: 0x%02X\n", Register.readB());
		System.out.printf("\trC: 0x%02X\n", Register.readC());
		System.out.printf("\trD: 0x%02X\n", Register.readD());
		System.out.printf("\trE: 0x%02X\n", Register.readE());

		System.out.println();

		System.out.println("DEBUG: Flags");
		System.out.println("\tZ: " + Register.getZeroFlag());
		System.out.println("\tN: " + Register.getSubtFlag());
		System.out.println("\tH: " + Register.getHCarryFlag());
		System.out.println("\tC: " + Register.getCarryFlag());
	}

	public static void dumpRegisters(String message)
		{
			System.out.println("DEBUG: " + message);
			System.out.println("DEBUG: Dumping Registers to console");
			System.out.printf("\n\trA: 0x%02X\n", Register.readA());
			System.out.printf("\trF: 0x%02X\n", Register.readF());
			System.out.printf("\trB: 0x%02X\n", Register.readB());
			System.out.printf("\trC: 0x%02X\n", Register.readC());
			System.out.printf("\trD: 0x%02X\n", Register.readD());
			System.out.printf("\trE: 0x%02X\n", Register.readE());

			System.out.println();

			System.out.printf("\trPC: 0x%04X\n", Register.readPC());
			System.out.printf("\trSP: 0x%04X\n", Register.readSP());

			System.out.println();

			System.out.println("DEBUG: Flags");
			System.out.println("\tZ: " + Register.getZeroFlag());
			System.out.println("\tN: " + Register.getSubtFlag());
			System.out.println("\tH: " + Register.getHCarryFlag());
			System.out.println("\tC: " + Register.getCarryFlag());
	}


}