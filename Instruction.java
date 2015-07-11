/*

method names of format:
Add B to A: asm: add a, b
add_A_B(); //returns number of cycles / 4

*/

/*

What needs to happen:


*/
public class Instruction
{
	//Section 3.3.1 8-bit Loads
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

	//Section 3.3.3 8-bit ALU
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

	//Section 3.3.5 Miscellaneous
	public static int nop() //Opcode: 0x00
	{
		//Do nothing

		//increase PC to next instruction
		Register.incPC(1);

		//return how many cycles / 4 instruction took.
		return 1;
	}

	//Section 3.3.8 Jumps
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

}