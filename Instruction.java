/*

method names of format:
Add B to A: asm: add a, b
add_A_B();

*/

/*

What needs to happen:
	*finish opcode ld_B_n()
	*Think about cpu cycles
	*Think about setting the next PC location

*/
public class Instruction
{
	//Section 3.3.3 8-bit ALU
	public static void add_A_A() //opcode: 0x87
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

		Register.writeA(sum & 0xFF);
	}

	public static void ld_B_n() //opcode: 0x06
	{

	}
}