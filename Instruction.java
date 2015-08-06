/*

method names of format:
Add B to A: asm: add a, b
add_A_B(); //returns number of cycles / 4

ld A, (HL)
ld_A_$HL();

*/

/*

What needs to happen:


*/
public class Instruction
{
	//Section 3.3.1-1 8-bit Loads
	public static int ld_B_n() //opcode: 0x06, 0xnn
	{
		int data;
		int address;
		//get address of immediate byte
		Register.incPC(1);
		address = Register.readPC();

		//get immediate byte
		data = Memory.read(address);

		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_C_n() //opcode: 0x0E, 0xnn
	{
		int data;
		int address;
		//get address of immediate byte
		Register.incPC(1);
		address = Register.readPC();

		//get immediate byte
		data = Memory.read(address);

		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_D_n() //opcode: 0x16, 0xnn
	{
		int data;
		int address;
		//get address of immediate byte
		Register.incPC(1);
		address = Register.readPC();

		//get immediate byte
		data = Memory.read(address);

		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_E_n() //opcode: 0x1E, 0xnn
	{
		int data;
		int address;
		//get address of immediate byte
		Register.incPC(1);
		address = Register.readPC();

		//get immediate byte
		data = Memory.read(address);

		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_H_n() //opcode: 0x26, 0xnn
	{
		int data;
		int address;
		//get address of immediate byte
		Register.incPC(1);
		address = Register.readPC();

		//get immediate byte
		data = Memory.read(address);

		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_L_n() //opcode: 0x2E, 0xnn
	{
		int data;
		int address;
		//get address of immediate byte
		Register.incPC(1);
		address = Register.readPC();

		//get immediate byte
		data = Memory.read(address);

		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	//Section 3.3.1-2 8-bit Loads
	public static int ld_A_A() //opcode: 7F
	{
		int data = Register.readA();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_B() //opcode: 78
	{
		int data = Register.readB();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_C() //opcode: 79
	{
		int data = Register.readC();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_D() //opcode: 7A
	{
		int data = Register.readD();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_E() //opcode: 7B
	{
		int data = Register.readE();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_H() //opcode: 7C
	{
		int data = Register.readH();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_L() //opcode: 7D
	{
		int data = Register.readL();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_$HL() //opcode: 7E
	{
		int data = Memory.read(Register.readHL());
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_B_B() //opcode: 40
	{
		int data = Register.readB();
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_B_C() //opcode: 41
	{
		int data = Register.readC();
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_B_D() //opcode: 42
	{
		int data = Register.readD();
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_B_E() //opcode: 43
	{
		int data = Register.readE();
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_B_H() //opcode: 44
	{
		int data = Register.readH();
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_B_L() //opcode: 45
	{
		int data = Register.readL();
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_B_$HL() //opcode: 46
	{
		int data = Memory.read(Register.readHL());
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_C_B() //opcode: 48
	{
		int data = Register.readB();
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_C_C() //opcode: 49
	{
		int data = Register.readC();
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_C_D() //opcode: 4A
	{
		int data = Register.readD();
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_C_E() //opcode: 4B
	{
		int data = Register.readE();
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_C_H() //opcode: 4C
	{
		int data = Register.readH();
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_C_L() //opcode: 4D
	{
		int data = Register.readL();
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_C_$HL() //opcode: 4E
	{
		int data = Memory.read(Register.readHL());
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_D_B() //opcode: 50
	{
		int data = Register.readB();
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_D_C() //opcode: 51
	{
		int data = Register.readC();
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_D_D() //opcode: 52
	{
		int data = Register.readD();
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_D_E() //opcode: 53
	{
		int data = Register.readE();
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_D_H() //opcode: 54
	{
		int data = Register.readH();
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_D_L() //opcode: 55
	{
		int data = Register.readL();
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_D_$HL() //opcode: 56
	{
		int data = Memory.read(Register.readHL());
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_E_B() //opcode: 58
	{
		int data = Register.readB();
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_E_C() //opcode: 59
	{
		int data = Register.readC();
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_E_D() //opcode: 5A
	{
		int data = Register.readD();
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_E_E() //opcode: 5B
	{
		int data = Register.readE();
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_E_H() //opcode: 5C
	{
		int data = Register.readH();
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_E_L() //opcode: 5D
	{
		int data = Register.readL();
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_E_$HL() //opcode: 5E
	{
		int data = Memory.read(Register.readHL());
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_H_B() //opcode: 60
	{
		int data = Register.readB();
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_H_C() //opcode: 61
	{
		int data = Register.readC();
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_H_D() //opcode: 62
	{
		int data = Register.readD();
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_H_E() //opcode: 63
	{
		int data = Register.readE();
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_H_H() //opcode: 64
	{
		int data = Register.readH();
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_H_L() //opcode: 65
	{
		int data = Register.readL();
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_H_$HL() //opcode: 66
	{
		int data = Memory.read(Register.readHL());
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_L_B() //opcode: 68
	{
		int data = Register.readB();
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_L_C() //opcode: 69
	{
		int data = Register.readC();
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_L_D() //opcode: 6A
	{
		int data = Register.readD();
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_L_E() //opcode: 6B
	{
		int data = Register.readE();
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_L_H() //opcode: 6C
	{
		int data = Register.readH();
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_L_L() //opcode: 6D
	{
		int data = Register.readL();
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_L_$HL() //opcode: 6E
	{
		int data = Memory.read(Register.readHL());
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_B() //opcode: 70
	{
		int data = Register.readB();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_C() //opcode: 71
	{
		int data = Register.readC();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_D() //opcode: 72
	{
		int data = Register.readD();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_E() //opcode: 73
	{
		int data = Register.readE();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_H() //opcode: 74
	{
		int data = Register.readH();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_L() //opcode: 75
	{
		int data = Register.readL();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_n() //opcode: 36
	{
		//get address of immediate byte
		Register.incPC(1);
		int data = Memory.read(Register.readPC());
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 3;
	}


	//Section 3.3.1-4 8-bit Loads
	public static int ld_$HL_A() //opcode: 0x77
	{
		int data = Register.readA();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}


	//Section 3.3.2-6 16-bit Loads
	public static int push_AF() //opcode: 0xF5
	{
		//decrement SP
		Register.decSP();
		//Store A
		Memory.write(Register.readSP(), Register.readA());
		//decrement SP
		Register.decSP();
		//Store F
		Memory.write(Register.readSP(), Register.readF());

		Register.incPC(1);

		//return instruction time
		return 4;
	}

	public static int push_BC() //opcode: 0xC5
	{
		//decrement SP
		Register.decSP();
		//Store B
		Memory.write(Register.readSP(), Register.readB());
		//decrement SP
		Register.decSP();
		//Store C
		Memory.write(Register.readSP(), Register.readC());

		Register.incPC(1);

		//return instruction time
		return 4;
	}

	public static int push_DE() //opcode: 0xD5
	{
		//decrement SP
		Register.decSP();
		//Store D
		Memory.write(Register.readSP(), Register.readD());
		//decrement SP
		Register.decSP();
		//Store E
		Memory.write(Register.readSP(), Register.readE());

		Register.incPC(1);

		//return instruction time
		return 4;
	}

	public static int push_HL() //opcode: 0xE5
	{
		//decrement SP
		Register.decSP();
		//Store H
		Memory.write(Register.readSP(), Register.readH());
		//decrement SP
		Register.decSP();
		//Store L
		Memory.write(Register.readSP(), Register.readL());

		Register.incPC(1);

		//return instruction time
		return 4;
	}

	//Section 3.3.2-7 16-bit loads
	public static int pop_AF() //opcode: 0xF1
	{
		//Get F
		Register.writeF(Memory.read(Register.readSP()));
		//increment SP
		Register.incSP();
		//get A
		Register.writeA(Memory.read(Register.readSP()));
		//increment SP
		Register.incSP();

		Register.incPC(1);

		//return instruction time
		return 3;
	}

	public static int pop_BC() //opcode: 0xC1
	{
		//Get C
		Register.writeC(Memory.read(Register.readSP()));
		//increment SP
		Register.incSP();
		//get B
		Register.writeB(Memory.read(Register.readSP()));
		//increment SP
		Register.incSP();

		Register.incPC(1);

		//return instruction time
		return 3;
	}

	public static int pop_DE() //opcode: 0xD1
	{
		//Get E
		Register.writeE(Memory.read(Register.readSP()));
		//increment SP
		Register.incSP();
		//get D
		Register.writeD(Memory.read(Register.readSP()));
		//increment SP
		Register.incSP();

		Register.incPC(1);

		//return instruction time
		return 3;
	}

	public static int pop_HL() //opcode: 0xE1
	{
		//Get L
		Register.writeL(Memory.read(Register.readSP()));
		//increment SP
		Register.incSP();
		//get H
		Register.writeH(Memory.read(Register.readSP()));
		//increment SP
		Register.incSP();

		Register.incPC(1);

		//return instruction time
		return 3;
	}


	//Section 3.3.3-1 8-bit ALU
	public static int add_A_A() //opcode: 0x87
	{
		int a = Register.readA();
		int sum = a << 1;
		int halfSum = (a & 0x0F) << 1;

		if((sum & 0xFF) == 0)
		{
			Register.setZeroFlag(true);
		}
		else
		{
			Register.setZeroFlag(false);
		}

		Register.setSubtFlag(false);

		if(halfSum == (halfSum & 0x0F))
		{
			Register.setHCarryFlag(false);
		}
		else
		{
			Register.setHCarryFlag(true);
		}

		if(sum == (sum & 0xFF))
		{
			Register.setCarryFlag(false);
		}
		else
		{
			Register.setCarryFlag(true);
		}

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_B() //opcode: 0x80
	{
		int a = Register.readA();
		int b = Register.readB();
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		if((sum & 0xFF) == 0)
		{
			Register.setZeroFlag(true);
		}
		else
		{
			Register.setZeroFlag(false);
		}

		Register.setSubtFlag(false);

		if(halfSum == (halfSum & 0x0F))
		{
			Register.setHCarryFlag(false);
		}
		else
		{
			Register.setHCarryFlag(true);
		}

		if(sum == (sum & 0xFF))
		{
			Register.setCarryFlag(false);
		}
		else
		{
			Register.setCarryFlag(true);
		}

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_C() //opcode: 0x81
	{
		int a = Register.readA();
		int b = Register.readC();
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		if((sum & 0xFF) == 0)
		{
			Register.setZeroFlag(true);
		}
		else
		{
			Register.setZeroFlag(false);
		}

		Register.setSubtFlag(false);

		if(halfSum == (halfSum & 0x0F))
		{
			Register.setHCarryFlag(false);
		}
		else
		{
			Register.setHCarryFlag(true);
		}

		if(sum == (sum & 0xFF))
		{
			Register.setCarryFlag(false);
		}
		else
		{
			Register.setCarryFlag(true);
		}

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_D() //opcode: 0x82
	{
		int a = Register.readA();
		int b = Register.readD();
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		if((sum & 0xFF) == 0)
		{
			Register.setZeroFlag(true);
		}
		else
		{
			Register.setZeroFlag(false);
		}

		Register.setSubtFlag(false);

		if(halfSum == (halfSum & 0x0F))
		{
			Register.setHCarryFlag(false);
		}
		else
		{
			Register.setHCarryFlag(true);
		}

		if(sum == (sum & 0xFF))
		{
			Register.setCarryFlag(false);
		}
		else
		{
			Register.setCarryFlag(true);
		}

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_E() //opcode: 0x83
	{
		int a = Register.readA();
		int b = Register.readE();
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		if((sum & 0xFF) == 0)
		{
			Register.setZeroFlag(true);
		}
		else
		{
			Register.setZeroFlag(false);
		}

		Register.setSubtFlag(false);

		if(halfSum == (halfSum & 0x0F))
		{
			Register.setHCarryFlag(false);
		}
		else
		{
			Register.setHCarryFlag(true);
		}

		if(sum == (sum & 0xFF))
		{
			Register.setCarryFlag(false);
		}
		else
		{
			Register.setCarryFlag(true);
		}

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_H() //opcode: 0x84
	{
		int a = Register.readA();
		int b = Register.readH();
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		if((sum & 0xFF) == 0)
		{
			Register.setZeroFlag(true);
		}
		else
		{
			Register.setZeroFlag(false);
		}

		Register.setSubtFlag(false);

		if(halfSum == (halfSum & 0x0F))
		{
			Register.setHCarryFlag(false);
		}
		else
		{
			Register.setHCarryFlag(true);
		}

		if(sum == (sum & 0xFF))
		{
			Register.setCarryFlag(false);
		}
		else
		{
			Register.setCarryFlag(true);
		}

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_L() //opcode: 0x85
	{
		int a = Register.readA();
		int b = Register.readL();
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		if((sum & 0xFF) == 0)
		{
			Register.setZeroFlag(true);
		}
		else
		{
			Register.setZeroFlag(false);
		}

		Register.setSubtFlag(false);

		if(halfSum == (halfSum & 0x0F))
		{
			Register.setHCarryFlag(false);
		}
		else
		{
			Register.setHCarryFlag(true);
		}

		if(sum == (sum & 0xFF))
		{
			Register.setCarryFlag(false);
		}
		else
		{
			Register.setCarryFlag(true);
		}

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_$HL() //opcode: 0x86
	{
		int a = Register.readA();
		int b = Memory.read(Register.readHL());
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		if((sum & 0xFF) == 0)
		{
			Register.setZeroFlag(true);
		}
		else
		{
			Register.setZeroFlag(false);
		}

		Register.setSubtFlag(false);

		if(halfSum == (halfSum & 0x0F))
		{
			Register.setHCarryFlag(false);
		}
		else
		{
			Register.setHCarryFlag(true);
		}

		if(sum == (sum & 0xFF))
		{
			Register.setCarryFlag(false);
		}
		else
		{
			Register.setCarryFlag(true);
		}

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_n() //opcode: 0xC6
	{
		int a = Register.readA();
		Register.incPC(1);
		int b = Memory.read(Register.readPC());
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		if((sum & 0xFF) == 0)
		{
			Register.setZeroFlag(true);
		}
		else
		{
			Register.setZeroFlag(false);
		}

		Register.setSubtFlag(false);

		if(halfSum == (halfSum & 0x0F))
		{
			Register.setHCarryFlag(false);
		}
		else
		{
			Register.setHCarryFlag(true);
		}

		if(sum == (sum & 0xFF))
		{
			Register.setCarryFlag(false);
		}
		else
		{
			Register.setCarryFlag(true);
		}

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 2;
	}

	//Section 3.3.3-7 8-bit ALU
	public static int xor_A() //Opcode: 0xAF
	{
		int data = Register.readA();
		int temp = data ^ data;
		Register.writeA(temp);
		if(temp == 0) Register.setZeroFlag(true);
		else Register.setZeroFlag(false);

		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int xor_B() //Opcode: 0xA8
	{
		int a = Register.readA();
		int b = Register.readB();
		int temp = a ^ b;
		Register.writeA(temp);
		if(temp == 0) Register.setZeroFlag(true);
		else Register.setZeroFlag(false);

		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int xor_C() //Opcode: 0xA9
	{
		int a = Register.readA();
		int b = Register.readC();
		int temp = a ^ b;
		Register.writeA(temp);
		if(temp == 0) Register.setZeroFlag(true);
		else Register.setZeroFlag(false);

		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int xor_D() //Opcode: 0xAA
	{
		int a = Register.readA();
		int b = Register.readD();
		int temp = a ^ b;
		Register.writeA(temp);
		if(temp == 0) Register.setZeroFlag(true);
		else Register.setZeroFlag(false);

		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int xor_E() //Opcode: 0xAB
	{
		int a = Register.readA();
		int b = Register.readE();
		int temp = a ^ b;
		Register.writeA(temp);
		if(temp == 0) Register.setZeroFlag(true);
		else Register.setZeroFlag(false);

		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int xor_H() //Opcode: 0xAC
	{
		int a = Register.readA();
		int b = Register.readH();
		int temp = a ^ b;
		Register.writeA(temp);
		if(temp == 0) Register.setZeroFlag(true);
		else Register.setZeroFlag(false);

		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int xor_L() //Opcode: 0xAD
	{
		int a = Register.readA();
		int b = Register.readL();
		int temp = a ^ b;
		Register.writeA(temp);
		if(temp == 0) Register.setZeroFlag(true);
		else Register.setZeroFlag(false);

		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int xor_$HL() //Opcode: 0xAE
	{
		int a = Memory.read(Register.readHL());
		int b = Register.readA();
		int temp = a ^ b;
		Register.writeA(temp);

		if(temp == 0) Register.setZeroFlag(true);
		else Register.setZeroFlag(false);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 2;
	}

	public static int xor_n() //opcode: 0xEE
	{
		Register.incPC(1);

		int a = Memory.read(Register.readPC());
		int b = Register.readA();
		int temp = a ^ b;
		Register.writeA(temp);

		if(temp == 0) Register.setZeroFlag(true);
		else Register.setZeroFlag(false);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 2;
	}

	//Section 3.3.5 Miscellaneous
	public static int nop() //Opcode: 0x00
	{
		//Do nothing

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	//Section 3.3.5-9 Miscellaneous
	public static int di() //opcode: 0xF3
	{
		CPU.nextIME = false;

		Register.incPC(1);

		//return instruction time
		return 1;
	}

	//Section 3.3.5-10 Miscellaneous
	public static int ei() //opcode: 0xFB
	{
		CPU.nextIME = true;

		Register.incPC(1);

		//return instruction time
		return 1;
	}

	//Section 3.3.8-1 Jumps
	public static int jp_nn() //Opcode: 0xC3, 0xnn, 0xnn
	{
		int address = 0x0000;
		int data;

		//get first immediate byte (lsB of address)
		Register.incPC(1);
		data = Memory.read(Register.readPC());
		address = data;

		//get second immediate byte (msB of address)
		Register.incPC(1);
		data = Memory.read(Register.readPC());
		address = address | (data << 8);

		//set PC to next instruction
		Register.writePC(address);

		//return how many cycles / 4 instruction took.
		return 3;
	}

	//Section 3.3.9-1 Calls
	public static int call_nn() //Opcode: 0xCD, 0xnn, 0xnn
	{
		//Get LS byte
		Register.incPC(1);
		int low = Memory.read(Register.readPC());
		//get MS byte
		Register.incPC(1);
		int high = Memory.read(Register.readPC());
		//push PC of next instruction
		Register.incPC(1);
		push_PC();
		//jump to address
		int address = (high << 8) | low;
		Register.writePC(address);

		return 3;
	}


	//Section 3.3.11-3 Returns
	public static int reti() //opcode 0xD9
	{
		pop_PC();
		CPU.nextIME = true;

		return 2;
	}


	//Extra instructions to make life simpler
	public static void push_PC()
	{
		int data = Register.readPC();

		//System.out.printf("\nDEBUG: pushing PC 0x%04X\n", data);

		//decrement SP
		Register.decSP();
		//write High Byte of PC
		int high = (data >>> 8) & 0xFF;
		Memory.write(Register.readSP(), high);
		//decrement SP
		Register.decSP();
		//write Low byte of PC
		int low = data & 0xFF;
		Memory.write(Register.readSP(), low);
	}

	public static void pop_PC()
	{
		//get low byte of PC
		int low = Memory.read(Register.readSP());
		//System.out.printf("\nDEBUG: popping low of PC. SP=0x%04X low=0x%02X", Register.readSP(), low );
		//increment SP
		Register.incSP();
		//get high byte of PC
		int high = Memory.read(Register.readSP());
		//increment SP
		Register.incSP();
		//write address to PC
		int data = (high << 8)|low;

		//System.out.printf("\nDEBUG: popping PC 0x%04X\n", data);
		Register.writePC(data);
	}


}