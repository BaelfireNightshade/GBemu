/* 	Notes:

	clock timings:
		Frequency: 4194304 HZ
		Period: 238.419ns
		Instruction time: 953.676ns

*/

import java.lang.System; //used for System.nanoTime()

public class CPU
{
	private static long nextCycle = 0;

	private static final int INSTR_TIME_STEP = 954;

	//used to check if time to execute next machine instruction
	public static void run()
	{
		if(System.nanoTime() > nextCycle)
		{
			machineCycle();
		}
	}

	public static void reset()
	{
		//reset memory
		//reset registers
		//reset cartridge
		//reset video
		//reset sound


		//set initial Instruction time
		nextCycle = System.nanoTime();
		nextCycle += INSTR_TIME_STEP;
	}

	public static void machineCycle()
	{
		int cyclesUsed = 0;
		int instruction = 0;

		//fetch
		instruction = Memory.read(Register.readPC());

		//decode/execute
		switch(instruction)
		{
			case 0x00:
				cyclesUsed = Instruction.nop();
			break;
			case 0x06:
				cyclesUsed = Instruction.ld_B_n();
			break;
			case 0x87:
				cyclesUsed = Instruction.add_A_A();
			break;
			case 0xC3:
				cyclesUsed = Instruction.jp_nn();
			break;
		}

		nextCycle += (cyclesUsed * INSTR_TIME_STEP);
	}
}