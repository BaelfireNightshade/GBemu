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
	//debug switches
	public final static boolean DEBUG_LD_D_D = false;

	public final static boolean DEBUG_ALL = false;

	public final static boolean DEBUG_AF = false;
	public final static boolean DEBUG_BC = false;
	public final static boolean DEBUG_DE = false;
	public final static boolean DEBUG_HL = false;
	public final static boolean DEBUG_PC = false;
	public final static boolean DEBUG_SP = false;

	public final static boolean DEBUG_A = DEBUG_AF | false;
	public final static boolean DEBUG_F = DEBUG_AF | false;
	public final static boolean DEBUG_B = DEBUG_BC | false;
	public final static boolean DEBUG_C = DEBUG_BC | false;
	public final static boolean DEBUG_D = DEBUG_DE | false;
	public final static boolean DEBUG_E = DEBUG_DE | false;
	public final static boolean DEBUG_H = DEBUG_HL | false;
	public final static boolean DEBUG_L = DEBUG_HL | false;



	//Section 3.3.1-1 8-bit Loads
	public static int ld_B_n() //opcode: 0x06, 0xnn
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: ld b,n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data;
		int address;
		//get address of immediate byte
		address = Register.readPC() + 1;

		//get immediate byte
		data = Memory.read(address);

		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int ld_C_n() //opcode: 0x0E, 0xnn
	{
		if(DEBUG_C | DEBUG_ALL)
		{
			System.out.printf("INST: ld c,n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data;
		int address;
		//get address of immediate byte
		address = Register.readPC() + 1;

		//get immediate byte
		data = Memory.read(address);

		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int ld_D_n() //opcode: 0x16, 0xnn
	{
		if(DEBUG_D | DEBUG_ALL)
		{
			System.out.printf("INST: ld d,n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data;
		int address;
		//get address of immediate byte
		address = Register.readPC() + 1;

		//get immediate byte
		data = Memory.read(address);

		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int ld_E_n() //opcode: 0x1E, 0xnn
	{
		if(DEBUG_E | DEBUG_ALL)
		{
			System.out.printf("INST: ld e,n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data;
		int address;
		//get address of immediate byte
		address = Register.readPC() + 1;

		//get immediate byte
		data = Memory.read(address);

		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int ld_H_n() //opcode: 0x26, 0xnn
	{
		if(DEBUG_H | DEBUG_ALL)
		{
			System.out.printf("INST: ld h,n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data;
		int address;
		//get address of immediate byte
		address = Register.readPC() + 1;

		//get immediate byte
		data = Memory.read(address);

		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int ld_L_n() //opcode: 0x2E, 0xnn
	{
		if(DEBUG_L | DEBUG_ALL)
		{
			System.out.printf("INST: ld l,n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data;
		int address;
		//get address of immediate byte
		address = Register.readPC() + 1;

		//get immediate byte
		data = Memory.read(address);

		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	//Section 3.3.1-2 8-bit Loads
	public static int ld_A_A() //opcode: 7F
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readA();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_B() //opcode: 78
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readB();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_C() //opcode: 79
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readC();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_D() //opcode: 7A
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readD();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_E() //opcode: 7B
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readE();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_H() //opcode: 7C
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readH();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_L() //opcode: 7D
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readL();
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_A_$HL() //opcode: 7E
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,(hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Memory.read(Register.readHL());
		Register.writeA(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_B_B() //opcode: 40
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: ld b,b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readB();
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_B_C() //opcode: 41
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: ld b,c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readC();
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_B_D() //opcode: 42
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: ld b,d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readD();
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_B_E() //opcode: 43
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: ld b,e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readE();
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_B_H() //opcode: 44
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: ld b,h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readH();
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_B_L() //opcode: 45
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: ld b,l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readL();
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_B_$HL() //opcode: 46
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: ld b,(hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Memory.read(Register.readHL());
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_C_B() //opcode: 48
	{
		if(DEBUG_C | DEBUG_ALL)
		{
			System.out.printf("INST: ld c,b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readB();
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_C_C() //opcode: 49
	{
		if(DEBUG_C | DEBUG_ALL)
		{
			System.out.printf("INST: ld c,c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readC();
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_C_D() //opcode: 4A
	{
		if(DEBUG_C | DEBUG_ALL)
		{
			System.out.printf("INST: ld c,d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readD();
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_C_E() //opcode: 4B
	{
		if(DEBUG_C | DEBUG_ALL)
		{
			System.out.printf("INST: ld c,e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readE();
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_C_H() //opcode: 4C
	{
		if(DEBUG_C | DEBUG_ALL)
		{
			System.out.printf("INST: ld c,h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readH();
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_C_L() //opcode: 4D
	{
		if(DEBUG_C | DEBUG_ALL)
		{
			System.out.printf("INST: ld c,l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readL();
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_C_$HL() //opcode: 4E
	{
		if(DEBUG_C | DEBUG_ALL)
		{
			System.out.printf("INST: ld c,(hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Memory.read(Register.readHL());
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_D_B() //opcode: 50
	{
		if(DEBUG_D | DEBUG_ALL)
		{
			System.out.printf("INST: ld d,b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readB();
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_D_C() //opcode: 51
	{
		if(DEBUG_D | DEBUG_ALL)
		{
			System.out.printf("INST: ld d,c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readC();
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_D_D() //opcode: 52
	{
		if(DEBUG_D | DEBUG_ALL)
		{
			System.out.printf("INST: ld d,d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}
		if(DEBUG_LD_D_D)
		{
			Register.dumpRegisters("ld d,d encountered");
		}

		int data = Register.readD();
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_D_E() //opcode: 53
	{
		if(DEBUG_D | DEBUG_ALL)
		{
			System.out.printf("INST: ld d,e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readE();
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_D_H() //opcode: 54
	{
		if(DEBUG_D | DEBUG_ALL)
		{
			System.out.printf("INST: ld d,h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readH();
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_D_L() //opcode: 55
	{
		if(DEBUG_D | DEBUG_ALL)
		{
			System.out.printf("INST: ld d,l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readL();
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_D_$HL() //opcode: 56
	{
		if(DEBUG_D | DEBUG_ALL)
		{
			System.out.printf("INST: ld d,(hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Memory.read(Register.readHL());
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_E_B() //opcode: 58
	{
		if(DEBUG_E | DEBUG_ALL)
		{
			System.out.printf("INST: ld e,b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readB();
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_E_C() //opcode: 59
	{
		if(DEBUG_E | DEBUG_ALL)
		{
			System.out.printf("INST: ld e,c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readC();
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_E_D() //opcode: 5A
	{
		if(DEBUG_E | DEBUG_ALL)
		{
			System.out.printf("INST: ld e,d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readD();
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_E_E() //opcode: 5B
	{
		if(DEBUG_E | DEBUG_ALL)
		{
			System.out.printf("INST: ld e,e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readE();
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_E_H() //opcode: 5C
	{
		if(DEBUG_E | DEBUG_ALL)
		{
			System.out.printf("INST: ld e,h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readH();
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_E_L() //opcode: 5D
	{
		if(DEBUG_E | DEBUG_ALL)
		{
			System.out.printf("INST: ld e,l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readL();
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_E_$HL() //opcode: 5E
	{
		if(DEBUG_E | DEBUG_ALL)
		{
			System.out.printf("INST: ld e,(hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Memory.read(Register.readHL());
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_H_B() //opcode: 60
	{
		if(DEBUG_H | DEBUG_ALL)
		{
			System.out.printf("INST: ld h,b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readB();
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_H_C() //opcode: 61
	{
		if(DEBUG_H | DEBUG_ALL)
		{
			System.out.printf("INST: ld h,c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readC();
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_H_D() //opcode: 62
	{
		if(DEBUG_H | DEBUG_ALL)
		{
			System.out.printf("INST: ld h,d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readD();
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_H_E() //opcode: 63
	{
		if(DEBUG_H | DEBUG_ALL)
		{
			System.out.printf("INST: ld h,e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readE();
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_H_H() //opcode: 64
	{
		if(DEBUG_H | DEBUG_ALL)
		{
			System.out.printf("INST: ld h,h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readH();
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_H_L() //opcode: 65
	{
		if(DEBUG_H | DEBUG_ALL)
		{
			System.out.printf("INST: ld h,l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readL();
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_H_$HL() //opcode: 66
	{
		if(DEBUG_H | DEBUG_ALL)
		{
			System.out.printf("INST: ld h,(hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Memory.read(Register.readHL());
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_L_B() //opcode: 68
	{
		if(DEBUG_L | DEBUG_ALL)
		{
			System.out.printf("INST: ld l,b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readB();
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_L_C() //opcode: 69
	{
		if(DEBUG_L | DEBUG_ALL)
		{
			System.out.printf("INST: ld l,c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}


		int data = Register.readC();
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_L_D() //opcode: 6A
	{
		if(DEBUG_L | DEBUG_ALL)
		{
			System.out.printf("INST: ld l,d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readD();
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_L_E() //opcode: 6B
	{
		if(DEBUG_L | DEBUG_ALL)
		{
			System.out.printf("INST: ld l,e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readE();
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_L_H() //opcode: 6C
	{
		if(DEBUG_L | DEBUG_ALL)
		{
			System.out.printf("INST: ld l,h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readH();
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_L_L() //opcode: 6D
	{
		if(DEBUG_L | DEBUG_ALL)
		{
			System.out.printf("INST: ld l,l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readL();
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_L_$HL() //opcode: 6E
	{
		if(DEBUG_L | DEBUG_ALL)
		{
			System.out.printf("INST: ld l,(hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Memory.read(Register.readHL());
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_B() //opcode: 70
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ld (hl),b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readB();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_C() //opcode: 71
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ld (hl),c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readC();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_D() //opcode: 72
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ld (hl),d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readD();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_E() //opcode: 73
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ld (hl),e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readE();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_H() //opcode: 74
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ld (hl),h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readH();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_L() //opcode: 75
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ld (hl),l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readL();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_n() //opcode: 36
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ld (hl),n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//get address of immediate byte
		int data = Memory.read(Register.readPC() + 1);
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 3;
	}

	//Section 3.3.1-3 8-bit Loads
	public static int ld_A_$BC() //opcode: 0x0A
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,(bc) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Register.writeA(Memory.read(Register.readBC()));

		//increase PC to next instruction
		Register.incPC(1);
		//return instruction time
		return 2;
	}

	public static int ld_A_$DE() //opcode: 0x1A
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,(de) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Register.writeA(Memory.read(Register.readDE()));

		//increase PC to next instruction
		Register.incPC(1);
		//return instruction time
		return 2;
	}

	public static int ld_A_$nn() //opcode: FA
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,(nn) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//fetch low byte of address
		int low = Memory.read(Register.readPC() + 1);
		//fetch high byte of address
		int high = Memory.read(Register.readPC() + 2);
		//combine to form address
		int address = (high << 8) | low;
		//fetch and store contents of address
		Register.writeA(Memory.read(address));

		//increase PC to next instruction
		Register.incPC(3);
		//return register time
		return 4;
	}

	public static int ld_A_n() //opcode: 0x3E
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//fetch immediate value to load
		Register.writeA(Memory.read(Register.readPC() + 1));

		//increase PC to next instruction
		Register.incPC(2);
		//return instruction time
		return 2;
	}

	//Section 3.3.1-4 8-bit Loads
	public static int ld_B_A() //opcode: 47
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: ld b,a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readA();
		Register.writeB(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_C_A() //opcode: 4F
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: ld c,a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readA();
		Register.writeC(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_D_A() //opcode: 57
	{
		if(DEBUG_D | DEBUG_ALL)
		{
			System.out.printf("INST: ld d,a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readA();
		Register.writeD(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_E_A() //opcode: 5F
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: ld e,a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readA();
		Register.writeE(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_H_A() //opcode: 67
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: ld h,a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readA();
		Register.writeH(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_L_A() //opcode: 6F
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: ld l,a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readA();
		Register.writeL(data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int ld_$BC_A() //opcode: 0x02
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ld (bc),a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readA();
		Memory.write(Register.readBC(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$DE_A() //opcode: 0x12
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ld (de),a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readA();
		Memory.write(Register.readDE(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$HL_A() //opcode: 0x77
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ld (hl),a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readA();
		Memory.write(Register.readHL(), data);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int ld_$nn_A() //opcode: EA
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ld (nn),a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readA();

		//get immediate address
		int low = Memory.read(Register.readPC() + 1);
		int high = Memory.read(Register.readPC() + 2);
		int address = (high << 8) | low;

		//store
		Memory.write(address, data);

		//increase PC to next instruction
		Register.incPC(3);
		//return instruction time
		return 4;
	}

	//Section 3.3.1-5 8-bit Loads
	public static int ld_A_$C() //opcode: 0xF2
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,(0xFF00+c) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//load low byte of address
		int low = Register.readC();
		//full address
		int address = 0xFF00 | low;

		Register.writeA(Memory.read(address));

		//increase PC to next instruction
		Register.incPC(1);
		//return instruction time
		return 2;
	}

	//Section 3.3.1-6 8-bit Loads
	public static int ld_$C_A() //opcode: 0xE2
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ld (0xFF00+c),a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//load low byte of address
		int low = Register.readC();
		//full address
		int address = 0xFF00 | low;

		Memory.write(address, Register.readA());

		//increase PC to next instruction
		Register.incPC(1);
		//return instruction time
		return 2;
	}

	//Section 3.3.1-9 8-bit Loads
	public static int ldd_A_$HL() //opcode: 0x3A
	{
		if(DEBUG_A | DEBUG_HL | DEBUG_ALL)
		{
			System.out.printf("INST: ldd a,(hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Register.writeA(Memory.read(Register.readHL()));
		Register.decHL();

		//increase PC to next instruction
		Register.incPC(1);
		//return instruction time
		return 2;
	}

	//Section 3.3.1-12 8-bit Loads
	public static int ldd_$HL_A() //opcode: 32
	{
		if(DEBUG_HL | DEBUG_ALL)
		{
			System.out.printf("INST: ldd (hl),a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Memory.write(Register.readHL(), Register.readA());
		Register.decHL();

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	//Section 3.3.1-15 8-bit Loads
	public static int ldi_A_$HL() //opcode: 0x2A
	{
		if(DEBUG_A | DEBUG_HL | DEBUG_ALL)
		{
			System.out.printf("INST: ldi a,(hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Register.writeA(Memory.read(Register.readHL()));
		Register.incHL();

		//increase PC to next instruction
		Register.incPC(1);
		//return instruction time
		return 2;
	}

	//Section 3.3.1-18 8-bit Loads
	public static int ldi_$HL_A() //opcode: 0x32
	{
		if(DEBUG_HL | DEBUG_ALL)
		{
			System.out.printf("INST: ldi (HL),a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Memory.write(Register.readHL(), Register.readA());
		Register.incHL();

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	//Section 3.3.1-19 8-bit Loads
	public static int ldh_$n_A() //opcode: 0xE0
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ld (0xFF00+n),a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//load low byte of address
		int low = Memory.read(Register.readPC() + 1);
		//full address
		int address = 0xFF00 | low;

		Memory.write(address, Register.readA());

		//increase PC to next instruction
		Register.incPC(2);
		//return instruction time
		return 3;
	}

	//Section 3.3.1-20 8-bit Loads
	public static int ldh_A_$n() //opcode: 0xF0
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: ld a,(0xFF00+n) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//load low byte of address
		int low = Memory.read(Register.readPC() + 1);
		//full address
		int address = 0xFF00 | low;

		Register.writeA(Memory.read(address));

		//increase PC to next instruction
		Register.incPC(2);
		//return instruction time
		return 3;
	}


	//Section 3.3.2-1 16-bit Loads
	public static int ld_BC_nn() //opcode 0x01
	{
		if(DEBUG_BC | DEBUG_ALL)
		{
			System.out.printf("INST: ld bc,nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//fetch immediate
		//store in C
		Register.writeC(Memory.read(Register.readPC() + 1));
		//fetch immediate
		//store in B
		Register.writeB(Memory.read(Register.readPC() + 2));

		//increase PC to next instruction
		Register.incPC(3);

		//return instruction time
		return 3;
	}

	public static int ld_DE_nn() //opcode 0x11
	{
		if(DEBUG_DE | DEBUG_ALL)
		{
			System.out.printf("INST: ld de,nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//fetch immediate
		//store in E
		Register.writeE(Memory.read(Register.readPC() + 1));
		//fetch immediate
		//store in D
		Register.writeD(Memory.read(Register.readPC() + 2));

		//increase PC to next instruction
		Register.incPC(3);

		//return instruction time
		return 3;
	}

	public static int ld_HL_nn() //opcode 0x21
	{
		if(DEBUG_HL | DEBUG_ALL)
		{
			System.out.printf("INST: ld hl,nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//fetch immediate
		//store in L
		Register.writeL(Memory.read(Register.readPC() + 1));
		//fetch immediate
		//store in H
		Register.writeH(Memory.read(Register.readPC() + 2));

		//increase PC to next instruction
		Register.incPC(3);

		//return instruction time
		return 3;
	}

	public static int ld_SP_nn() //opcode 0x31
	{
		if(DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: ld sp,nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}
		//fetch immediate
		//store in low
		int low = Memory.read(Register.readPC() + 1);
		//fetch immediate
		//store in high
		int high = Memory.read(Register.readPC() + 2);

		int full = (high << 8) | low;

		Register.writeSP(full);

		//increase PC to next instruction
		Register.incPC(3);

		//return instruction time
		return 3;
	}

	//Section 3.3.2-6 16-bit Loads
	public static int push_AF() //opcode: 0xF5
	{
		if(DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: push af ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

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
		if(DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: push bc ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

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
		if(DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: push de ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

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
		if(DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: push hl ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

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
		if(DEBUG_AF | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: pop af ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

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
		if(DEBUG_BC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: pop bc ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

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
		if(DEBUG_DE | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: pop de ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

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
		if(DEBUG_HL | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: pop hl ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

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
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: add a,a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int sum = a << 1;
		int halfSum = (a & 0x0F) << 1;

		Register.setZeroFlag((sum & 0xFF) == 0);

		Register.setSubtFlag(false);

		Register.setHCarryFlag(halfSum != (halfSum & 0x0F));

		Register.setCarryFlag(sum != (sum & 0xFF));

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_B() //opcode: 0x80
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: add a,b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readB();
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		Register.setZeroFlag((sum & 0xFF) == 0);

		Register.setSubtFlag(false);

		Register.setHCarryFlag(halfSum != (halfSum & 0x0F));

		Register.setCarryFlag(sum == (sum & 0xFF));

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_C() //opcode: 0x81
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: add a,c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readC();
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		Register.setZeroFlag((sum & 0xFF) == 0);

		Register.setSubtFlag(false);

		Register.setHCarryFlag(halfSum != (halfSum & 0x0F));

		Register.setCarryFlag(sum == (sum & 0xFF));

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_D() //opcode: 0x82
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: add a,d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readD();
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		Register.setZeroFlag((sum & 0xFF) == 0);

		Register.setSubtFlag(false);

		Register.setHCarryFlag(halfSum != (halfSum & 0x0F));

		Register.setCarryFlag(sum == (sum & 0xFF));

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_E() //opcode: 0x83
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: add a,e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readE();
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		Register.setZeroFlag((sum & 0xFF) == 0);

		Register.setSubtFlag(false);

		Register.setHCarryFlag(halfSum != (halfSum & 0x0F));

		Register.setCarryFlag(sum == (sum & 0xFF));

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_H() //opcode: 0x84
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: add a,h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readH();
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		Register.setZeroFlag((sum & 0xFF) == 0);

		Register.setSubtFlag(false);

		Register.setHCarryFlag(halfSum != (halfSum & 0x0F));

		Register.setCarryFlag(sum == (sum & 0xFF));

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_L() //opcode: 0x85
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: add a,l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readL();
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		Register.setZeroFlag((sum & 0xFF) == 0);

		Register.setSubtFlag(false);

		Register.setHCarryFlag(halfSum != (halfSum & 0x0F));

		Register.setCarryFlag(sum == (sum & 0xFF));

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_$HL() //opcode: 0x86
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: add a,(hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Memory.read(Register.readHL());
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		Register.setZeroFlag((sum & 0xFF) == 0);

		Register.setSubtFlag(false);

		Register.setHCarryFlag(halfSum != (halfSum & 0x0F));

		Register.setCarryFlag(sum == (sum & 0xFF));

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int add_A_n() //opcode: 0xC6
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: add a,n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Memory.read(Register.readPC() + 1);
		int sum = a + b;
		int halfSum = (a & 0x0F) + (b & 0x0F);

		Register.setZeroFlag((sum & 0xFF) == 0);

		Register.setSubtFlag(false);

		Register.setHCarryFlag(halfSum != (halfSum & 0x0F));

		Register.setCarryFlag(sum == (sum & 0xFF));

		//write sum to Register A
		Register.writeA(sum & 0xFF);

		//increase PC to next instruction
		Register.incPC(2);

		//return how many cycles / 4 instruction took.
		return 2;
	}

	//Section 3.3.3-3 8-bit ALU
	public static int sub_A_A() //Opcode: 0x97
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: sub a,a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = a;

		int diff = a - b;
		int halfDiff = (a & 0x0F) - (b & 0x0F);

		Register.setZeroFlag((diff & 0xFF) == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag(halfDiff != (halfDiff & 0x0F));
		Register.setCarryFlag(diff != (diff & 0xFF));

		Register.writeA(diff & 0xFF);

		Register.incPC(1);

		return 1;
	}

	public static int sub_A_B() //Opcode: 0x90
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: sub a,b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readB();

		int diff = a - b;
		int halfDiff = (a & 0x0F) - (b & 0x0F);

		Register.setZeroFlag((diff & 0xFF) == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag(halfDiff != (halfDiff & 0x0F));
		Register.setCarryFlag(diff != (diff & 0xFF));

		Register.writeA(diff & 0xFF);

		Register.incPC(1);

		return 1;
	}

	public static int sub_A_C() //Opcode: 0x91
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: sub a,c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readC();

		int diff = a - b;
		int halfDiff = (a & 0x0F) - (b & 0x0F);

		Register.setZeroFlag((diff & 0xFF) == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag(halfDiff != (halfDiff & 0x0F));
		Register.setCarryFlag(diff != (diff & 0xFF));

		Register.writeA(diff & 0xFF);

		Register.incPC(1);

		return 1;
	}

	public static int sub_A_D() //Opcode: 0x92
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: sub a,d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readD();

		int diff = a - b;
		int halfDiff = (a & 0x0F) - (b & 0x0F);

		Register.setZeroFlag((diff & 0xFF) == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag(halfDiff != (halfDiff & 0x0F));
		Register.setCarryFlag(diff != (diff & 0xFF));

		Register.writeA(diff & 0xFF);

		Register.incPC(1);

		return 1;
	}

	public static int sub_A_E() //Opcode: 0x93
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: sub a,e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readE();

		int diff = a - b;
		int halfDiff = (a & 0x0F) - (b & 0x0F);

		Register.setZeroFlag((diff & 0xFF) == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag(halfDiff != (halfDiff & 0x0F));
		Register.setCarryFlag(diff != (diff & 0xFF));

		Register.writeA(diff & 0xFF);

		Register.incPC(1);

		return 1;
	}

	public static int sub_A_H() //Opcode: 0x94
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: sub a,h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readH();

		int diff = a - b;
		int halfDiff = (a & 0x0F) - (b & 0x0F);

		Register.setZeroFlag((diff & 0xFF) == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag(halfDiff != (halfDiff & 0x0F));
		Register.setCarryFlag(diff != (diff & 0xFF));

		Register.writeA(diff & 0xFF);

		Register.incPC(1);

		return 1;
	}

	public static int sub_A_L() //Opcode: 0x95
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: sub a,l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readL();

		int diff = a - b;
		int halfDiff = (a & 0x0F) - (b & 0x0F);

		Register.setZeroFlag((diff & 0xFF) == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag(halfDiff != (halfDiff & 0x0F));
		Register.setCarryFlag(diff != (diff & 0xFF));

		Register.writeA(diff & 0xFF);

		Register.incPC(1);

		return 1;
	}

	public static int sub_A_$HL() //Opcode: 0x96
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: sub a,(hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Memory.read(Register.readHL());

		int diff = a - b;
		int halfDiff = (a & 0x0F) - (b & 0x0F);

		Register.setZeroFlag((diff & 0xFF) == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag(halfDiff != (halfDiff & 0x0F));
		Register.setCarryFlag(diff != (diff & 0xFF));

		Register.writeA(diff & 0xFF);

		Register.incPC(1);

		return 2;
	}

	public static int sub_A_n() //Opcode: 0xD6
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: sub a,n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Memory.read(Register.readPC() + 1);

		int diff = a - b;
		int halfDiff = (a & 0x0F) - (b & 0x0F);

		Register.setZeroFlag((diff & 0xFF) == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag(halfDiff != (halfDiff & 0x0F));
		Register.setCarryFlag(diff != (diff & 0xFF));

		Register.writeA(diff & 0xFF);

		Register.incPC(2);

		return 2;
	}

	//Section 3.3.3-5 8-bit ALU
	public static int and_A() //Opcode: 0xA7
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: and a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = a;
		int result = a & b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int and_B() //Opcode: 0xA0
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: and b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readB();
		int result = a & b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int and_C() //Opcode: 0xA1
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: and c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readC();
		int result = a & b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int and_D() //Opcode: 0xA2
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: and d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readD();
		int result = a & b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int and_E() //Opcode: 0xA3
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: and e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readE();
		int result = a & b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int and_H() //Opcode: 0xA4
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: and h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readH();
		int result = a & b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int and_L() //Opcode: 0xA5
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: and l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readL();
		int result = a & b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int and_$HL() //Opcode: 0xA6
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: and (hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Memory.read(Register.readHL());
		int result = a & b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int and_n() //Opcode: 0xE6
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: and n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Memory.read(Register.readPC() + 1);
		int result = a & b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 1;
	}

	//Section 3.3.3-6 8-bit ALU
	public static int or_A() //Opcode: 0xB7
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: or a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = a;
		int result = a | b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int or_B() //Opcode: 0xB0
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: or b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readB();
		int result = a | b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int or_C() //Opcode: 0xB1
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: or c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readC();
		int result = a | b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int or_D() //Opcode: 0xB2
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: or d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readD();
		int result = a | b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int or_E() //Opcode: 0xB3
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: or e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readE();
		int result = a | b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int or_H() //Opcode: 0xB4
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: or h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readH();
		int result = a | b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int or_L() //Opcode: 0xB5
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: or l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readL();
		int result = a | b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	public static int or_$HL() //Opcode: 0xB6
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: or (hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int address = Register.readHL();
		int b = Memory.read(address);
		int result = a | b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int or_n() //Opcode: 0xF6
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: or n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Memory.read(Register.readPC() + 1);
		int result = a | b;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 1;
	}

	//Section 3.3.3-7 8-bit ALU
	public static int xor_A() //Opcode: 0xAF
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: xor a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int data = Register.readA();
		int temp = data ^ data;
		Register.writeA(temp);

		Register.setZeroFlag(temp == 0);
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
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: xor b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readB();
		int temp = a ^ b;
		Register.writeA(temp);

		Register.setZeroFlag(temp == 0);

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
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: xor c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readC();
		int temp = a ^ b;
		Register.writeA(temp);

		Register.setZeroFlag(temp == 0);
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
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: xor d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readD();
		int temp = a ^ b;
		Register.writeA(temp);

		Register.setZeroFlag(temp == 0);
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
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: xor e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readE();
		int temp = a ^ b;
		Register.writeA(temp);

		Register.setZeroFlag(temp == 0);
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
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: xor h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readH();
		int temp = a ^ b;
		Register.writeA(temp);

		Register.setZeroFlag(temp == 0);
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
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: xor l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readL();
		int temp = a ^ b;
		Register.writeA(temp);

		Register.setZeroFlag(temp == 0);
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
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: xor (hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Memory.read(Register.readHL());
		int b = Register.readA();
		int temp = a ^ b;
		Register.writeA(temp);

		Register.setZeroFlag(temp == 0);
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
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: xor n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}


		int a = Memory.read(Register.readPC() + 1);
		int b = Register.readA();
		int temp = a ^ b;
		Register.writeA(temp);

		Register.setZeroFlag(temp == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(2);

		//return how many cycles / 4 instruction took.
		return 2;
	}

	//Section 3.3.3-8 8-bit ALU
	public static int cp_A() //opcode: 0xBF
	{
		if(DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: cp a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = a;
		int result = (a - b) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < (b & 0x0F));
		Register.setCarryFlag(a < b);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int cp_B() //opcode: 0xB8
	{
		if(DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: cp b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readB();
		int result = (a - b) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < (b & 0x0F));
		Register.setCarryFlag(a < b);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int cp_C() //opcode: 0xB9
	{
		if(DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: cp c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readC();
		int result = (a - b) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < (b & 0x0F));
		Register.setCarryFlag(a < b);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int cp_D() //opcode: 0xBA
	{
		if(DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: cp d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readD();
		int result = (a - b) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < (b & 0x0F));
		Register.setCarryFlag(a < b);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int cp_E() //opcode: 0xBB
	{
		if(DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: cp e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readE();
		int result = (a - b) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < (b & 0x0F));
		Register.setCarryFlag(a < b);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int cp_H() //opcode: 0xBC
	{
		if(DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: cp h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readH();
		int result = (a - b) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < (b & 0x0F));
		Register.setCarryFlag(a < b);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int cp_L() //opcode: 0xBD
	{
		if(DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: cp l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Register.readL();
		int result = (a - b) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < (b & 0x0F));
		Register.setCarryFlag(a < b);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int cp_$HL() //opcode: 0xBE
	{
		if(DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: cp (hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Memory.read(Register.readHL());
		int result = (a - b) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < (b & 0x0F));
		Register.setCarryFlag(a < b);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 2;
	}

	public static int cp_n() //opcode: 0xFE
	{
		if(DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: cp n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int b = Memory.read(Register.readPC() + 1);
		int result = (a - b) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < (b & 0x0F));
		Register.setCarryFlag(a < b);

		//Increase PC to next Instruction
		Register.incPC(2);
		//return instruction time
		return 2;
	}

	//Section 3.3.3-9 8-bit ALU
	public static int inc_A() //opcode: 0x3C
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: inc a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int result = (a + 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag((a & 0x0F) == 0x0F);

		Register.writeA(result);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int inc_B() //opcode: 0x04
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: inc b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readB();
		int result = (a + 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag((a & 0x0F) == 0x0F);

		Register.writeB(result);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int inc_C() //opcode: 0x0C
	{
		if(DEBUG_C | DEBUG_ALL)
		{
			System.out.printf("INST: inc c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readC();
		int result = (a + 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag((a & 0x0F) == 0x0F);

		Register.writeC(result);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int inc_D() //opcode: 0x14
	{
		if(DEBUG_D | DEBUG_ALL)
		{
			System.out.printf("INST: inc d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readD();
		int result = (a + 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag((a & 0x0F) == 0x0F);

		Register.writeD(result);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int inc_E() //opcode: 0x1C
	{
		if(DEBUG_E | DEBUG_ALL)
		{
			System.out.printf("INST: inc e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readE();
		int result = (a + 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag((a & 0x0F) == 0x0F);

		Register.writeE(result);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int inc_H() //opcode: 0x24
	{
		if(DEBUG_H | DEBUG_ALL)
		{
			System.out.printf("INST: inc h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readH();
		int result = (a + 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag((a & 0x0F) == 0x0F);

		Register.writeH(result);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int inc_L() //opcode: 0x2C
	{
		if(DEBUG_L | DEBUG_ALL)
		{
			System.out.printf("INST: inc l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readL();
		int result = (a + 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag((a & 0x0F) == 0x0F);

		Register.writeL(result);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 1;
	}

	public static int inc_$HL() //opcode: 0x34
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: inc (hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int address = Register.readHL();
		int a = Memory.read(address);
		int result = (a + 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag((a & 0x0F) == 0x0F);

		Memory.write(address, result);

		//Increase PC to next Instruction
		Register.incPC(1);
		//return instruction time
		return 3;
	}

	//Section 3.3.3-10 8-Bit ALU
	public static int dec_A() //opcode: 0x3D
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: dec a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int result = (a - 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < 1);

		Register.writeA(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int dec_B() //opcode: 0x05
	{
		if(DEBUG_B | DEBUG_ALL)
		{
			System.out.printf("INST: dec b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readB();
		int result = (a - 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < 1);

		Register.writeB(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int dec_C() //opcode: 0x0D
	{
		if(DEBUG_C | DEBUG_ALL)
		{
			System.out.printf("INST: dec c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readC();
		int result = (a - 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < 1);

		Register.writeC(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int dec_D() //opcode: 0x15
	{
		if(DEBUG_D | DEBUG_ALL)
		{
			System.out.printf("INST: dec d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readD();
		int result = (a - 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < 1);

		Register.writeD(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int dec_E() //opcode: 0x1D
	{
		if(DEBUG_E | DEBUG_ALL)
		{
			System.out.printf("INST: dec e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readE();
		int result = (a - 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < 1);

		Register.writeE(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int dec_H() //opcode: 0x25
	{
		if(DEBUG_H | DEBUG_ALL)
		{
			System.out.printf("INST: dec h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readH();
		int result = (a - 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < 1);

		Register.writeH(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int dec_L() //opcode: 0x2D
	{
		if(DEBUG_L | DEBUG_ALL)
		{
			System.out.printf("INST: dec l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readL();
		int result = (a - 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < 1);

		Register.writeL(result);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	public static int dec_$HL() //opcode: 0x35
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: dec (hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Memory.read(Register.readHL());
		int result = (a - 1) & 0xFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(true);
		Register.setHCarryFlag((a & 0x0F) < 1);

		Memory.write(Register.readHL(), result);

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 3;
	}

	//Section 3.3.4-1 16-Bit Arithmetic
	public static int add_HL_BC() //opcode: 0x09
	{
		if(DEBUG_HL | DEBUG_ALL)
		{
			System.out.printf("INST: add hl,bc ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readHL();
		int b = Register.readBC();
		int result = (a + b);
		int endResult = result & 0xFFFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag((((a & 0x0FFF) + (b & 0x0FFF))& 0x1000) != 0);
		Register.setCarryFlag(endResult != result);

		Register.writeHL(endResult);

		//increment PC to next instruction
		Register.incPC(1);
		//return instruction time
		return 2;
	}

	public static int add_HL_DE() //opcode: 0x19
	{
		if(DEBUG_HL | DEBUG_ALL)
		{
			System.out.printf("INST: add hl,de ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readHL();
		int b = Register.readDE();
		int result = (a + b);
		int endResult = result & 0xFFFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag((((a & 0x0FFF) + (b & 0x0FFF))& 0x1000) != 0);
		Register.setCarryFlag(endResult != result);

		Register.writeHL(endResult);

		//increment PC to next instruction
		Register.incPC(1);
		//return instruction time
		return 2;
	}

	public static int add_HL_HL() //opcode: 0x29
	{
		if(DEBUG_HL | DEBUG_ALL)
		{
			System.out.printf("INST: add hl,hl ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readHL();
		int b = a;
		int result = (a + b);
		int endResult = result & 0xFFFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag((((a & 0x0FFF) + (b & 0x0FFF))& 0x1000) != 0);
		Register.setCarryFlag(endResult != result);

		Register.writeHL(endResult);

		//increment PC to next instruction
		Register.incPC(1);
		//return instruction time
		return 2;
	}

	public static int add_HL_SP() //opcode: 0x39
	{
		if(DEBUG_HL | DEBUG_ALL)
		{
			System.out.printf("INST: add hl,sp ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readHL();
		int b = Register.readSP();
		int result = (a + b);
		int endResult = result & 0xFFFF;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag((((a & 0x0FFF) + (b & 0x0FFF))& 0x1000) != 0);
		Register.setCarryFlag(endResult != result);

		Register.writeHL(endResult);

		//increment PC to next instruction
		Register.incPC(1);
		//return instruction time
		return 2;
	}

	//Section 3.3.4-3 16-Bit Arithmetic
	public static int inc_BC() //opcode: 0x03
	{
		if(DEBUG_BC | DEBUG_ALL)
		{
			System.out.printf("INST: inc bc ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Register.incBC();

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int inc_DE() //opcode: 0x13
	{
		if(DEBUG_DE | DEBUG_ALL)
		{
			System.out.printf("INST: inc de ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Register.incDE();

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int inc_HL() //opcode: 0x23
	{
		if(DEBUG_HL | DEBUG_ALL)
		{
			System.out.printf("INST: inc hl ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Register.incHL();

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int inc_SP() //opcode: 0x33
	{
		if(DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: inc sp ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Register.incSP();

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	//Section 3.3.4-4 16-Bit Arithmetic
	public static int dec_BC() //opcode: 0x0B
	{
		if(DEBUG_BC | DEBUG_ALL)
		{
			System.out.printf("INST: dec bc ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Register.decBC();

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int dec_DE() //opcode: 0x1B
	{
		if(DEBUG_DE | DEBUG_ALL)
		{
			System.out.printf("INST: dec de ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Register.decDE();

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int dec_HL() //opcode: 0x2B
	{
		if(DEBUG_HL | DEBUG_ALL)
		{
			System.out.printf("INST: dec hl ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Register.decHL();

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}

	public static int dec_SP() //opcode: 0x3B
	{
		if(DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: dec sp ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Register.decSP();

		//increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 2;
	}


	//Section 3.3.5-1 Miscellaneous
	public static int swap_A() //Opcode: 0xCB, 0x37
	{
		if(DEBUG_A | DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: swap a ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readA();
		int result = BitTwiddling.swapNibbles(a);
		Register.writeA(result);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(2);
		//return instruction time
		return 2;
	}

	public static int swap_B() //Opcode: 0xCB, 0x30
	{
		if(DEBUG_B | DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: swap b ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readB();
		int result = BitTwiddling.swapNibbles(a);
		Register.writeB(result);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(2);
		//return instruction time
		return 2;
	}

	public static int swap_C() //Opcode: 0xCB, 0x31
	{
		if(DEBUG_C | DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: swap c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readC();
		int result = BitTwiddling.swapNibbles(a);
		Register.writeC(result);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(2);
		//return instruction time
		return 2;
	}

	public static int swap_D() //Opcode: 0xCB, 0x32
	{
		if(DEBUG_D | DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: swap d ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readD();
		int result = BitTwiddling.swapNibbles(a);
		Register.writeD(result);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(2);
		//return instruction time
		return 2;
	}

	public static int swap_E() //Opcode: 0xCB, 0x33
	{
		if(DEBUG_E | DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: swap e ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readE();
		int result = BitTwiddling.swapNibbles(a);
		Register.writeE(result);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(2);
		//return instruction time
		return 2;
	}

	public static int swap_H() //Opcode: 0xCB, 0x34
	{
		if(DEBUG_H | DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: swap h ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readH();
		int result = BitTwiddling.swapNibbles(a);
		Register.writeH(result);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(2);
		//return instruction time
		return 2;
	}

	public static int swap_L() //Opcode: 0xCB, 0x35
	{
		if(DEBUG_L | DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: swap l ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int a = Register.readL();
		int result = BitTwiddling.swapNibbles(a);
		Register.writeL(result);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(2);
		//return instruction time
		return 2;
	}

	public static int swap_$HL() //Opcode: 0xCB, 0x36
	{
		if(DEBUG_F | DEBUG_ALL)
		{
			System.out.printf("INST: swap (hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int addr = Register.readHL();
		int a = Memory.read(addr);
		int result = BitTwiddling.swapNibbles(a);
		Memory.write(addr, result);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag(false);

		//increase PC to next instruction
		Register.incPC(2);
		//return instruction time
		return 4;
	}

	//Section 3.3.5-3 Miscellaneous
	public static int cpl() //Opcode: 0x2F
	{
		if(DEBUG_A | DEBUG_ALL)
		{
			System.out.printf("INST: cpl ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		Register.writeA(~Register.readA());

		//Increase PC to next instruction
		Register.incPC(1);

		//return instruction time
		return 1;
	}

	//Section 3.3.5-6 Miscellaneous
	public static int nop() //Opcode: 0x00
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: nop ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//Do nothing

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	//Section 3.3.5-9 Miscellaneous
	public static int di() //opcode: 0xF3
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: di ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		CPU.nextIME = false;

		Register.incPC(1);

		//return instruction time
		return 1;
	}

	//Section 3.3.5-10 Miscellaneous
	public static int ei() //opcode: 0xFB
	{
		if(DEBUG_ALL)
		{
			System.out.printf("INST: ei ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		CPU.nextIME = true;

		Register.incPC(1);

		//return instruction time
		return 1;
	}


	//Section 3.3.6-11 Rotates & Shifts
	public static int srl_A() //Opcode: 0xCB, 0x3F
	{
		int register = Register.readA();
		int result = register >>> 1;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag((register & 0x1) == 0x1);

		Register.writeA(result);

		Register.incPC(2);

		return 2;
	}

	public static int srl_B() //Opcode: 0xCB, 0x38
	{
		int register = Register.readB();
		int result = register >>> 1;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag((register & 0x1) == 0x1);

		Register.writeB(result);

		Register.incPC(2);

		return 2;
	}

	public static int srl_C() //Opcode: 0xCB, 0x39
	{
		int register = Register.readC();
		int result = register >>> 1;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag((register & 0x1) == 0x1);

		Register.writeC(result);

		Register.incPC(2);

		return 2;
	}

	public static int srl_D() //Opcode: 0xCB, 0x3A
	{
		int register = Register.readD();
		int result = register >>> 1;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag((register & 0x1) == 0x1);

		Register.writeD(result);

		Register.incPC(2);

		return 2;
	}

	public static int srl_E() //Opcode: 0xCB, 0x3B
	{
		int register = Register.readE();
		int result = register >>> 1;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag((register & 0x1) == 0x1);

		Register.writeE(result);

		Register.incPC(2);

		return 2;
	}

	public static int srl_H() //Opcode: 0xCB, 0x3C
	{
		int register = Register.readH();
		int result = register >>> 1;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag((register & 0x1) == 0x1);

		Register.writeH(result);

		Register.incPC(2);

		return 2;
	}

	public static int srl_L() //Opcode: 0xCB, 0x3D
	{
		int register = Register.readL();
		int result = register >>> 1;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag((register & 0x1) == 0x1);

		Register.writeL(result);

		Register.incPC(2);

		return 2;
	}

	public static int srl_$HL() //Opcode: 0xCB, 0x3E
	{
		int address = Register.readHL();
		int register = Memory.read(address);
		int result = register >>> 1;

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(false);
		Register.setCarryFlag((register & 0x1) == 0x1);

		Memory.write(address, result);

		Register.incPC(2);

		return 4;
	}


	//Section 3.3.7-1 Bit Opcodes

	public static int bit_0_A() //Opcode: 0xCB, 0x47
	{
		int register = Register.readA();
		int result = register & (1 << 0);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_1_A() //Opcode: 0xCB, 0x4F
	{
		int register = Register.readA();
		int result = register & (1 << 1);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_2_A() //Opcode: 0xCB, 0x57
	{
		int register = Register.readA();
		int result = register & (1 << 2);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_3_A() //Opcode: 0xCB, 0x5F
	{
		int register = Register.readA();
		int result = register & (1 << 3);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_4_A() //Opcode: 0xCB, 0x67
	{
		int register = Register.readA();
		int result = register & (1 << 4);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_5_A() //Opcode: 0xCB, 0x6F
	{
		int register = Register.readA();
		int result = register & (1 << 5);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_6_A() //Opcode: 0xCB, 0x77
	{
		int register = Register.readA();
		int result = register & (1 << 6);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_7_A() //Opcode: 0xCB, 0x7F
	{
		int register = Register.readA();
		int result = register & (1 << 7);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_0_B() //Opcode: 0xCB, 0x40
	{
		int register = Register.readB();
		int result = register & (1 << 0);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_1_B() //Opcode: 0xCB, 0x48
	{
		int register = Register.readB();
		int result = register & (1 << 1);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_2_B() //Opcode: 0xCB, 0x50
	{
		int register = Register.readB();
		int result = register & (1 << 2);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_3_B() //Opcode: 0xCB, 0x58
	{
		int register = Register.readB();
		int result = register & (1 << 3);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_4_B() //Opcode: 0xCB, 0x60
	{
		int register = Register.readB();
		int result = register & (1 << 4);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_5_B() //Opcode: 0xCB, 0x68
	{
		int register = Register.readB();
		int result = register & (1 << 5);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_6_B() //Opcode: 0xCB, 0x70
	{
		int register = Register.readB();
		int result = register & (1 << 6);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_7_B() //Opcode: 0xCB, 0x78
	{
		int register = Register.readB();
		int result = register & (1 << 7);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_0_C() //Opcode: 0xCB, 0x41
	{
		int register = Register.readC();
		int result = register & (1 << 0);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_1_C() //Opcode: 0xCB, 0x49
	{
		int register = Register.readC();
		int result = register & (1 << 1);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_2_C() //Opcode: 0xCB, 0x51
	{
		int register = Register.readC();
		int result = register & (1 << 2);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_3_C() //Opcode: 0xCB, 0x59
	{
		int register = Register.readC();
		int result = register & (1 << 3);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_4_C() //Opcode: 0xCB, 0x61
	{
		int register = Register.readC();
		int result = register & (1 << 4);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_5_C() //Opcode: 0xCB, 0x69
	{
		int register = Register.readC();
		int result = register & (1 << 5);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_6_C() //Opcode: 0xCB, 0x71
	{
		int register = Register.readC();
		int result = register & (1 << 6);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_7_C() //Opcode: 0xCB, 0x79
	{
		int register = Register.readC();
		int result = register & (1 << 7);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_0_D() //Opcode: 0xCB, 0x42
	{
		int register = Register.readD();
		int result = register & (1 << 0);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_1_D() //Opcode: 0xCB, 0x4A
	{
		int register = Register.readD();
		int result = register & (1 << 1);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_2_D() //Opcode: 0xCB, 0x52
	{
		int register = Register.readD();
		int result = register & (1 << 2);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_3_D() //Opcode: 0xCB, 0x5A
	{
		int register = Register.readD();
		int result = register & (1 << 3);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_4_D() //Opcode: 0xCB, 0x62
	{
		int register = Register.readD();
		int result = register & (1 << 4);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_5_D() //Opcode: 0xCB, 0x6A
	{
		int register = Register.readD();
		int result = register & (1 << 5);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_6_D() //Opcode: 0xCB, 0x72
	{
		int register = Register.readD();
		int result = register & (1 << 6);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_7_D() //Opcode: 0xCB, 0x7A
	{
		int register = Register.readD();
		int result = register & (1 << 7);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_0_E() //Opcode: 0xCB, 0x43
	{
		int register = Register.readE();
		int result = register & (1 << 0);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_1_E() //Opcode: 0xCB, 0x4B
	{
		int register = Register.readE();
		int result = register & (1 << 1);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_2_E() //Opcode: 0xCB, 0x53
	{
		int register = Register.readE();
		int result = register & (1 << 2);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_3_E() //Opcode: 0xCB, 0x5B
	{
		int register = Register.readE();
		int result = register & (1 << 3);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_4_E() //Opcode: 0xCB, 0x63
	{
		int register = Register.readE();
		int result = register & (1 << 4);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_5_E() //Opcode: 0xCB, 0x6B
	{
		int register = Register.readE();
		int result = register & (1 << 5);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_6_E() //Opcode: 0xCB, 0x73
	{
		int register = Register.readE();
		int result = register & (1 << 6);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_7_E() //Opcode: 0xCB, 0x7B
	{
		int register = Register.readE();
		int result = register & (1 << 7);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_0_H() //Opcode: 0xCB, 0x44
	{
		int register = Register.readH();
		int result = register & (1 << 0);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_1_H() //Opcode: 0xCB, 0x4C
	{
		int register = Register.readH();
		int result = register & (1 << 1);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_2_H() //Opcode: 0xCB, 0x54
	{
		int register = Register.readH();
		int result = register & (1 << 2);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_3_H() //Opcode: 0xCB, 0x5C
	{
		int register = Register.readH();
		int result = register & (1 << 3);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_4_H() //Opcode: 0xCB, 0x64
	{
		int register = Register.readH();
		int result = register & (1 << 4);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_5_H() //Opcode: 0xCB, 0x6C
	{
		int register = Register.readH();
		int result = register & (1 << 5);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_6_H() //Opcode: 0xCB, 0x74
	{
		int register = Register.readH();
		int result = register & (1 << 6);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_7_H() //Opcode: 0xCB, 0x7C
	{
		int register = Register.readH();
		int result = register & (1 << 7);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_0_L() //Opcode: 0xCB, 0x45
	{
		int register = Register.readL();
		int result = register & (1 << 0);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_1_L() //Opcode: 0xCB, 0x4D
	{
		int register = Register.readL();
		int result = register & (1 << 1);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_2_L() //Opcode: 0xCB, 0x55
	{
		int register = Register.readL();
		int result = register & (1 << 2);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_3_L() //Opcode: 0xCB, 0x5D
	{
		int register = Register.readL();
		int result = register & (1 << 3);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_4_L() //Opcode: 0xCB, 0x65
	{
		int register = Register.readL();
		int result = register & (1 << 4);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_5_L() //Opcode: 0xCB, 0x6D
	{
		int register = Register.readL();
		int result = register & (1 << 5);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_6_L() //Opcode: 0xCB, 0x75
	{
		int register = Register.readL();
		int result = register & (1 << 6);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_7_L() //Opcode: 0xCB, 0x7D
	{
		int register = Register.readL();
		int result = register & (1 << 7);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int bit_0_$HL() //Opcode: 0xCB, 0x46
	{
		int register = Memory.read(Register.readHL());
		int result = register & (1 << 0);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int bit_1_$HL() //Opcode: 0xCB, 0x4E
	{
		int register = Memory.read(Register.readHL());
		int result = register & (1 << 1);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int bit_2_$HL() //Opcode: 0xCB, 0x56
	{
		int register = Memory.read(Register.readHL());
		int result = register & (1 << 2);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int bit_3_$HL() //Opcode: 0xCB, 0x5E
	{
		int register = Memory.read(Register.readHL());
		int result = register & (1 << 3);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int bit_4_$HL() //Opcode: 0xCB, 0x66
	{
		int register = Memory.read(Register.readHL());
		int result = register & (1 << 4);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int bit_5_$HL() //Opcode: 0xCB, 0x6E
	{
		int register = Memory.read(Register.readHL());
		int result = register & (1 << 5);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int bit_6_$HL() //Opcode: 0xCB, 0x76
	{
		int register = Memory.read(Register.readHL());
		int result = register & (1 << 6);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int bit_7_$HL() //Opcode: 0xCB, 0x7E
	{
		int register = Memory.read(Register.readHL());
		int result = register & (1 << 7);

		Register.setZeroFlag(result == 0);
		Register.setSubtFlag(false);
		Register.setHCarryFlag(true);

		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	//Section 3.3.7-3 Bit Opcodes

	public static int res_0_A() //Opcode: 0xCB, 0x87
	{
		int register = Register.readA();
		int result = register & (~(1 << 0));

		Register.writeA(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_0_B() //Opcode: 0xCB, 0x80
	{
		int register = Register.readB();
		int result = register & (~(1 << 0));

		Register.writeB(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_0_C() //Opcode: 0xCB, 0x81
	{
		int register = Register.readC();
		int result = register & (~(1 << 0));

		Register.writeC(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_0_D() //Opcode: 0xCB, 0x82
	{
		int register = Register.readD();
		int result = register & (~(1 << 0));

		Register.writeD(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_0_E() //Opcode: 0xCB, 0x83
	{
		int register = Register.readE();
		int result = register & (~(1 << 0));

		Register.writeE(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_0_H() //Opcode: 0xCB, 0x84
	{
		int register = Register.readH();
		int result = register & (~(1 << 0));

		Register.writeH(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_0_L() //Opcode: 0xCB, 0x85
	{
		int register = Register.readL();
		int result = register & (~(1 << 0));

		Register.writeL(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_0_$HL() //Opcode: 0xCB, 0x86
	{
		int address = Register.readHL();
		int register = Memory.read(address);
		int result = register & (~(1 << 0));

		Memory.write(address, result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int res_1_A() //Opcode: 0xCB, 0x8F
	{
		int register = Register.readA();
		int result = register & (~(1 << 1));

		Register.writeA(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_1_B() //Opcode: 0xCB, 0x88
	{
		int register = Register.readB();
		int result = register & (~(1 << 1));

		Register.writeB(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_1_C() //Opcode: 0xCB, 0x89
	{
		int register = Register.readC();
		int result = register & (~(1 << 1));

		Register.writeC(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_1_D() //Opcode: 0xCB, 0x8A
	{
		int register = Register.readD();
		int result = register & (~(1 << 1));

		Register.writeD(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_1_E() //Opcode: 0xCB, 0x8B
	{
		int register = Register.readE();
		int result = register & (~(1 << 1));

		Register.writeE(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_1_H() //Opcode: 0xCB, 0x8C
	{
		int register = Register.readH();
		int result = register & (~(1 << 1));

		Register.writeH(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_1_L() //Opcode: 0xCB, 0x8D
	{
		int register = Register.readL();
		int result = register & (~(1 << 1));

		Register.writeL(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_1_$HL() //Opcode: 0xCB, 0x8E
	{
		int address = Register.readHL();
		int register = Memory.read(address);
		int result = register & (~(1 << 1));

		Memory.write(address, result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int res_2_A() //Opcode: 0xCB, 0x97
	{
		int register = Register.readA();
		int result = register & (~(1 << 2));

		Register.writeA(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_2_B() //Opcode: 0xCB, 0x90
	{
		int register = Register.readB();
		int result = register & (~(1 << 2));

		Register.writeB(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_2_C() //Opcode: 0xCB, 0x91
	{
		int register = Register.readC();
		int result = register & (~(1 << 2));

		Register.writeC(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_2_D() //Opcode: 0xCB, 0x92
	{
		int register = Register.readD();
		int result = register & (~(1 << 2));

		Register.writeD(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_2_E() //Opcode: 0xCB, 0x93
	{
		int register = Register.readE();
		int result = register & (~(1 << 2));

		Register.writeE(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_2_H() //Opcode: 0xCB, 0x94
	{
		int register = Register.readH();
		int result = register & (~(1 << 2));

		Register.writeH(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_2_L() //Opcode: 0xCB, 0x95
	{
		int register = Register.readL();
		int result = register & (~(1 << 2));

		Register.writeL(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_2_$HL() //Opcode: 0xCB, 0x96
	{
		int address = Register.readHL();
		int register = Memory.read(address);
		int result = register & (~(1 << 2));

		Memory.write(address, result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int res_3_A() //Opcode: 0xCB, 0x9F
	{
		int register = Register.readA();
		int result = register & (~(1 << 3));

		Register.writeA(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_3_B() //Opcode: 0xCB, 0x98
	{
		int register = Register.readB();
		int result = register & (~(1 << 3));

		Register.writeB(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_3_C() //Opcode: 0xCB, 0x99
	{
		int register = Register.readC();
		int result = register & (~(1 << 3));

		Register.writeC(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_3_D() //Opcode: 0xCB, 0x9A
	{
		int register = Register.readD();
		int result = register & (~(1 << 3));

		Register.writeD(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_3_E() //Opcode: 0xCB, 0x9B
	{
		int register = Register.readE();
		int result = register & (~(1 << 3));

		Register.writeE(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_3_H() //Opcode: 0xCB, 0x9C
	{
		int register = Register.readH();
		int result = register & (~(1 << 3));

		Register.writeH(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_3_L() //Opcode: 0xCB, 0x9D
	{
		int register = Register.readL();
		int result = register & (~(1 << 3));

		Register.writeL(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_3_$HL() //Opcode: 0xCB, 0x9E
	{
		int address = Register.readHL();
		int register = Memory.read(address);
		int result = register & (~(1 << 3));

		Memory.write(address, result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int res_4_A() //Opcode: 0xCB, 0xA7
	{
		int register = Register.readA();
		int result = register & (~(1 << 4));

		Register.writeA(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_4_B() //Opcode: 0xCB, 0xA0
	{
		int register = Register.readB();
		int result = register & (~(1 << 4));

		Register.writeB(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_4_C() //Opcode: 0xCB, 0xA1
	{
		int register = Register.readC();
		int result = register & (~(1 << 4));

		Register.writeC(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_4_D() //Opcode: 0xCB, 0xA2
	{
		int register = Register.readD();
		int result = register & (~(1 << 4));

		Register.writeD(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_4_E() //Opcode: 0xCB, 0xA3
	{
		int register = Register.readE();
		int result = register & (~(1 << 4));

		Register.writeE(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_4_H() //Opcode: 0xCB, 0xA4
	{
		int register = Register.readH();
		int result = register & (~(1 << 4));

		Register.writeH(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_4_L() //Opcode: 0xCB, 0xA5
	{
		int register = Register.readL();
		int result = register & (~(1 << 4));

		Register.writeL(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_4_$HL() //Opcode: 0xCB, 0xA6
	{
		int address = Register.readHL();
		int register = Memory.read(address);
		int result = register & (~(1 << 4));

		Memory.write(address, result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int res_5_A() //Opcode: 0xCB, 0xAF
	{
		int register = Register.readA();
		int result = register & (~(1 << 5));

		Register.writeA(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_5_B() //Opcode: 0xCB, 0xA8
	{
		int register = Register.readB();
		int result = register & (~(1 << 5));

		Register.writeB(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_5_C() //Opcode: 0xCB, 0xA9
	{
		int register = Register.readC();
		int result = register & (~(1 << 5));

		Register.writeC(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_5_D() //Opcode: 0xCB, 0xAA
	{
		int register = Register.readD();
		int result = register & (~(1 << 5));

		Register.writeD(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_5_E() //Opcode: 0xCB, 0xAB
	{
		int register = Register.readE();
		int result = register & (~(1 << 5));

		Register.writeE(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_5_H() //Opcode: 0xCB, 0xAC
	{
		int register = Register.readH();
		int result = register & (~(1 << 5));

		Register.writeH(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_5_L() //Opcode: 0xCB, 0xAD
	{
		int register = Register.readL();
		int result = register & (~(1 << 5));

		Register.writeL(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_5_$HL() //Opcode: 0xCB, 0xAE
	{
		int address = Register.readHL();
		int register = Memory.read(address);
		int result = register & (~(1 << 5));

		Memory.write(address, result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int res_6_A() //Opcode: 0xCB, 0xB7
	{
		int register = Register.readA();
		int result = register & (~(1 << 6));

		Register.writeA(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_6_B() //Opcode: 0xCB, 0xB0
	{
		int register = Register.readB();
		int result = register & (~(1 << 6));

		Register.writeB(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_6_C() //Opcode: 0xCB, 0xB1
	{
		int register = Register.readC();
		int result = register & (~(1 << 6));

		Register.writeC(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_6_D() //Opcode: 0xCB, 0xB2
	{
		int register = Register.readD();
		int result = register & (~(1 << 6));

		Register.writeD(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_6_E() //Opcode: 0xCB, 0xB3
	{
		int register = Register.readE();
		int result = register & (~(1 << 6));

		Register.writeE(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_6_H() //Opcode: 0xCB, 0xB4
	{
		int register = Register.readH();
		int result = register & (~(1 << 6));

		Register.writeH(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_6_L() //Opcode: 0xCB, 0xB5
	{
		int register = Register.readL();
		int result = register & (~(1 << 6));

		Register.writeL(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_6_$HL() //Opcode: 0xCB, 0xB6
	{
		int address = Register.readHL();
		int register = Memory.read(address);
		int result = register & (~(1 << 6));

		Memory.write(address, result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}

	public static int res_7_A() //Opcode: 0xCB, 0xBF
	{
		int register = Register.readA();
		int result = register & (~(1 << 7));

		Register.writeA(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_7_B() //Opcode: 0xCB, 0xB8
	{
		int register = Register.readB();
		int result = register & (~(1 << 7));

		Register.writeB(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_7_C() //Opcode: 0xCB, 0xB9
	{
		int register = Register.readC();
		int result = register & (~(1 << 7));

		Register.writeC(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_7_D() //Opcode: 0xCB, 0xBA
	{
		int register = Register.readD();
		int result = register & (~(1 << 7));

		Register.writeD(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_7_E() //Opcode: 0xCB, 0xBB
	{
		int register = Register.readE();
		int result = register & (~(1 << 7));

		Register.writeE(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_7_H() //Opcode: 0xCB, 0xBC
	{
		int register = Register.readH();
		int result = register & (~(1 << 7));

		Register.writeH(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_7_L() //Opcode: 0xCB, 0xBD
	{
		int register = Register.readL();
		int result = register & (~(1 << 7));

		Register.writeL(result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 2;
	}

	public static int res_7_$HL() //Opcode: 0xCB, 0xBE
	{
		int address = Register.readHL();
		int register = Memory.read(address);
		int result = register & (~(1 << 7));

		Memory.write(address, result);


		//inc PC to next instruction
		Register.incPC(2);

		//return instruction time
		return 4;
	}


	//Section 3.3.8-1 Jumps
	public static int jp_nn() //Opcode: 0xC3, 0xnn, 0xnn
	{
		if(DEBUG_PC | DEBUG_ALL)
		{
			System.out.printf("INST: jp nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int address = 0x0000;
		int data;

		//get first immediate byte (lsB of address)
		data = Memory.read(Register.readPC() + 1);
		address = data;

		//get second immediate byte (msB of address)
		data = Memory.read(Register.readPC() + 2);
		address = address | (data << 8);

		//set PC to next instruction
		Register.writePC(address);

		//return how many cycles / 4 instruction took.
		return 3;
	}

	//Section 3.3.8-2 Jumps
	public static int jp_nz_nn() //opcode: 0xC2
	{
		if(DEBUG_PC | DEBUG_ALL)
		{
			System.out.printf("INST: jp nz nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		if(!Register.getZeroFlag())
		{
			int address = 0x0000;
			int data;

			//get first immediate byte (lsB of address)
			data = Memory.read(Register.readPC() + 1);
			address = data;

			//get second immediate byte (msB of address)
			data = Memory.read(Register.readPC() + 2);
			address = address | (data << 8);

			//set PC to next instruction
			Register.writePC(address);
		}
		else
		{
			Register.incPC(3);
		}

		//return how many cycles / 4 instruction took.
		return 3;
	}

	public static int jp_z_nn() //opcode: 0xCA
	{
		if(DEBUG_PC | DEBUG_ALL)
		{
			System.out.printf("INST: jp z nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		if(Register.getZeroFlag())
		{
			int address = 0x0000;
			int data;

			//get first immediate byte (lsB of address)
			data = Memory.read(Register.readPC() + 1);
			address = data;

			//get second immediate byte (msB of address)
			data = Memory.read(Register.readPC() + 2);
			address = address | (data << 8);

			//set PC to next instruction
			Register.writePC(address);
		}
		else
		{
			Register.incPC(3);
		}

		//return how many cycles / 4 instruction took.
		return 3;
	}

	public static int jp_nc_nn() //opcode: 0xD2
	{
		if(DEBUG_PC | DEBUG_ALL)
		{
			System.out.printf("INST: jp nc nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		if(!Register.getCarryFlag())
		{
			int address = 0x0000;
			int data;

			//get first immediate byte (lsB of address)
			data = Memory.read(Register.readPC() + 1);
			address = data;

			//get second immediate byte (msB of address)
			data = Memory.read(Register.readPC() + 2);
			address = address | (data << 8);

			//set PC to next instruction
			Register.writePC(address);
		}
		else
		{
			Register.incPC(3);
		}

		//return how many cycles / 4 instruction took.
		return 3;
	}

	public static int jp_c_nn() //opcode: 0xDA
	{
		if(DEBUG_PC | DEBUG_ALL)
		{
			System.out.printf("INST: jp c nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		if(!Register.getCarryFlag())
		{
			int address = 0x0000;
			int data;

			//get first immediate byte (lsB of address)
			data = Memory.read(Register.readPC() + 1);
			address = data;

			//get second immediate byte (msB of address)
			data = Memory.read(Register.readPC() + 2);
			address = address | (data << 8);

			//set PC to next instruction
			Register.writePC(address);
		}
		else
		{
			Register.incPC(3);
		}

		//return how many cycles / 4 instruction took.
		return 3;
	}

	//Section 3.3.8-3 Jumps
	public static int jp_$HL() //opcode: 0xE9
	{
		if(DEBUG_PC | DEBUG_ALL)
		{
			System.out.printf("INST: jp (hl) ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//jump to address contained in HL.
		int address = Register.readHL();
		Register.writePC(address);

		//return instruction time
		return 1;
	}

	//Section 3.3.8-4 Jumps
	public static int jr_n() //opcode: 0x18
	{
		if(DEBUG_PC | DEBUG_ALL)
		{
			System.out.printf("INST: jr n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int displacement = Memory.read(Register.readPC() + 1);

		int currentAddress = Register.readPC() + 2;
		displacement = BitTwiddling.signExt8to16(displacement);
		int newAddress = (displacement + currentAddress) & 0xFFFF;
		Register.writePC(newAddress);


		//return instruction time
		return 2;
	}

	//Section 3.3.8-5 Jumps
	public static int jr_nz_n() //opcode: 0x20
	{
		if(DEBUG_PC | DEBUG_ALL)
		{
			System.out.printf("INST: jr nz n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int displacement = Memory.read(Register.readPC() + 1);
		if(!Register.getZeroFlag())
		{
			int currentAddress = Register.readPC() + 2;
			displacement = BitTwiddling.signExt8to16(displacement);
			int newAddress = (displacement + currentAddress) & 0xFFFF;
			Register.writePC(newAddress);
		}
		else
		{
			Register.incPC(2);
		}

		//return instruction time
		return 2;
	}

	public static int jr_z_n() //opcode: 0x28
	{
		if(DEBUG_PC | DEBUG_ALL)
		{
			System.out.printf("INST: jr z n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int displacement = Memory.read(Register.readPC() + 1);
		if(Register.getZeroFlag())
		{
			int currentAddress = Register.readPC() + 2;
			displacement = BitTwiddling.signExt8to16(displacement);
			int newAddress = (displacement + currentAddress) & 0xFFFF;
			Register.writePC(newAddress);
		}
		else
		{
			Register.incPC(2);
		}

		//return instruction time
		return 2;
	}

	public static int jr_nc_n() //opcode: 0x30
	{
		if(DEBUG_PC | DEBUG_ALL)
		{
			System.out.printf("INST: jr nc n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int displacement = Memory.read(Register.readPC() + 1);
		if(!Register.getCarryFlag())
		{
			int currentAddress = Register.readPC() + 2;
			displacement = BitTwiddling.signExt8to16(displacement);
			int newAddress = (displacement + currentAddress) & 0xFFFF;
			Register.writePC(newAddress);
		}
		else
		{
			Register.incPC(2);
		}

		//return instruction time
		return 2;
	}

	public static int jr_c_n() //opcode: 0x38
	{
		if(DEBUG_PC | DEBUG_ALL)
		{
			System.out.printf("INST: jr c n ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		int displacement = Memory.read(Register.readPC() + 1);
		if(Register.getCarryFlag())
		{
			int currentAddress = Register.readPC() + 2;
			displacement = BitTwiddling.signExt8to16(displacement);
			int newAddress = (displacement + currentAddress) & 0xFFFF;
			Register.writePC(newAddress);
		}
		else
		{
			Register.incPC(2);
		}

		//return instruction time
		return 2;
	}


	//Section 3.3.9-1 Calls
	public static int call_nn() //Opcode: 0xCD, 0xnn, 0xnn
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: call nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//Get LS byte
		int low = Memory.read(Register.readPC() + 1);
		//get MS byte
		int high = Memory.read(Register.readPC() + 2);
		//push PC of next instruction
		Register.incPC(3);
		push_PC();
		//jump to address
		int address = (high << 8) | low;
		Register.writePC(address);

		return 3;
	}

	//Section 3.3.9-2 Calls
	public static int call_nz_nn() //Opcode: 0xC4
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: call nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//Get LS byte
		int low = Memory.read(Register.readPC() + 1);
		//get MS byte
		int high = Memory.read(Register.readPC() + 2);
		//push PC of next instruction
		Register.incPC(3);
		if(!Register.getZeroFlag())
		{
			push_PC();
			//jump to address
			int address = (high << 8) | low;
			Register.writePC(address);
		}

		return 3;

	}

	public static int call_z_nn() //Opcode: 0xCC
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: call nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//Get LS byte
		int low = Memory.read(Register.readPC() + 1);
		//get MS byte
		int high = Memory.read(Register.readPC() + 2);
		//push PC of next instruction
		Register.incPC(3);
		if(Register.getZeroFlag())
		{
			push_PC();
			//jump to address
			int address = (high << 8) | low;
			Register.writePC(address);
		}

		return 3;

	}

	public static int call_nc_nn() //Opcode: 0xD4
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: call nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//Get LS byte
		int low = Memory.read(Register.readPC() + 1);
		//get MS byte
		int high = Memory.read(Register.readPC() + 2);
		//push PC of next instruction
		Register.incPC(3);
		if(!Register.getCarryFlag())
		{
			push_PC();
			//jump to address
			int address = (high << 8) | low;
			Register.writePC(address);
		}

		return 3;

	}

	public static int call_c_nn() //Opcode: 0xDC
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: call nn ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//Get LS byte
		int low = Memory.read(Register.readPC() + 1);
		//get MS byte
		int high = Memory.read(Register.readPC() + 2);
		//push PC of next instruction
		Register.incPC(3);
		if(Register.getCarryFlag())
		{
			push_PC();
			//jump to address
			int address = (high << 8) | low;
			Register.writePC(address);
		}

		return 3;

	}


	//Section 3.3.10-1 Restarts
	public static int rst_00() //Opcode: 0xC7
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: rst 0x00 ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//push next instruction to stack
		Register.incPC(1);
		push_PC();

		//jump to address
		Register.writePC(0x0000);

		//return instruction time
		return 8;
	}

	public static int rst_08() //Opcode: 0xCF
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: rst 0x08 ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//push next instruction to stack
		Register.incPC(1);
		push_PC();

		//jump to address
		Register.writePC(0x0008);

		//return instruction time
		return 8;
	}

	public static int rst_10() //Opcode: 0xD7
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: rst 0x10 ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//push next instruction to stack
		Register.incPC(1);
		push_PC();

		//jump to address
		Register.writePC(0x0010);

		//return instruction time
		return 8;
	}

	public static int rst_18() //Opcode: 0xDF
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: rst 0x18 ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//push next instruction to stack
		Register.incPC(1);
		push_PC();

		//jump to address
		Register.writePC(0x0018);

		//return instruction time
		return 8;
	}

	public static int rst_20() //Opcode: 0xE7
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: rst 0x20 ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//push next instruction to stack
		Register.incPC(1);
		push_PC();

		//jump to address
		Register.writePC(0x0020);

		//return instruction time
		return 8;
	}

	public static int rst_28() //Opcode: 0xEF
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: rst 0x28 ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//push next instruction to stack
		Register.incPC(1);
		push_PC();

		//jump to address
		Register.writePC(0x0028);

		//return instruction time
		return 8;
	}

	public static int rst_30() //Opcode: 0xF7
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: rst 0x30 ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//push next instruction to stack
		Register.incPC(1);
		push_PC();

		//jump to address
		Register.writePC(0x0030);

		//return instruction time
		return 8;
	}

	public static int rst_38() //Opcode: 0xFF
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: rst 0x38 ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		//push next instruction to stack
		Register.incPC(1);
		push_PC();

		//jump to address
		Register.writePC(0x0038);

		//return instruction time
		return 8;
	}


	//Section 3.3.11-1 Returns
	public static int ret() //opcode 0xC9
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: ret ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		pop_PC();

		return 2;
	}

	//Section 3.3.11-2 Returns
	public static int ret_nz() //opcode 0xC0
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: ret nz ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		if(Register.getZeroFlag() == false)
		{
			pop_PC();
		}

		return 2;
	}

	public static int ret_z() //opcode 0xC8
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: ret z ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		if(Register.getZeroFlag() == true)
		{
			pop_PC();
		}

		return 2;
	}

	public static int ret_nc() //opcode 0xD0
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: ret nc ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		if(Register.getCarryFlag() == false)
		{
			pop_PC();
		}

		return 2;
	}

	public static int ret_c() //opcode 0xD8
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: ret c ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

		if(Register.getCarryFlag() == true)
		{
			pop_PC();
		}

		return 2;
	}

	//Section 3.3.11-3 Returns
	public static int reti() //opcode 0xD9
	{
		if(DEBUG_PC | DEBUG_SP | DEBUG_ALL)
		{
			System.out.printf("INST: reti ADDR: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
		}

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
