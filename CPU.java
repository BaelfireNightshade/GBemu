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
		Register.writeAF(0x01B0);
		Register.writeBC(0x0013);
		Register.writeDE(0x00D8);
		Register.writeHL(0x014D);
		Register.writeSP(0xFFFE);
		Register.writePC(0x0100);
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
			case 0x0E:
				cyclesUsed = Instruction.ld_C_n();
			break;
			case 0x16:
				cyclesUsed = Instruction.ld_D_n();
			break;
			case 0x1E:
				cyclesUsed = Instruction.ld_E_n();
			break;
			case 0x26:
				cyclesUsed = Instruction.ld_H_n();
			break;
			case 0x2E:
				cyclesUsed = Instruction.ld_L_n();
			break;
			case 0x36:
				cyclesUsed = Instruction.ld_$HL_n();
			break;
			case 0x40:
				cyclesUsed = Instruction.ld_B_B();
			break;
			case 0x41:
				cyclesUsed = Instruction.ld_B_C();
			break;
			case 0x42:
				cyclesUsed = Instruction.ld_B_D();
			break;
			case 0x43:
				cyclesUsed = Instruction.ld_B_E();
			break;
			case 0x44:
				cyclesUsed = Instruction.ld_B_H();
			break;
			case 0x45:
				cyclesUsed = Instruction.ld_B_L();
			break;
			case 0x46:
				cyclesUsed = Instruction.ld_B_$HL();
			break;
			case 0x48:
				cyclesUsed = Instruction.ld_C_B();
			break;
			case 0x49:
				cyclesUsed = Instruction.ld_C_C();
			break;
			case 0x4A:
				cyclesUsed = Instruction.ld_C_D();
			break;
			case 0x4B:
				cyclesUsed = Instruction.ld_C_E();
			break;
			case 0x4C:
				cyclesUsed = Instruction.ld_C_H();
			break;
			case 0x4D:
				cyclesUsed = Instruction.ld_C_L();
			break;
			case 0x4E:
				cyclesUsed = Instruction.ld_C_$HL();
			break;
			case 0x50:
				cyclesUsed = Instruction.ld_D_B();
			break;
			case 0x51:
				cyclesUsed = Instruction.ld_D_C();
			break;
			case 0x52:
				cyclesUsed = Instruction.ld_D_D();
			break;
			case 0x53:
				cyclesUsed = Instruction.ld_D_E();
			break;
			case 0x54:
				cyclesUsed = Instruction.ld_D_H();
			break;
			case 0x55:
				cyclesUsed = Instruction.ld_D_L();
			break;
			case 0x56:
				cyclesUsed = Instruction.ld_D_$HL();
			break;
			case 0x58:
				cyclesUsed = Instruction.ld_E_B();
			break;
			case 0x59:
				cyclesUsed = Instruction.ld_E_C();
			break;
			case 0x5A:
				cyclesUsed = Instruction.ld_E_D();
			break;
			case 0x5B:
				cyclesUsed = Instruction.ld_E_E();
			break;
			case 0x5C:
				cyclesUsed = Instruction.ld_E_H();
			break;
			case 0x5D:
				cyclesUsed = Instruction.ld_E_L();
			break;
			case 0x5E:
				cyclesUsed = Instruction.ld_E_$HL();
			break;
			case 0x60:
				cyclesUsed = Instruction.ld_H_B();
			break;
			case 0x61:
				cyclesUsed = Instruction.ld_H_C();
			break;
			case 0x62:
				cyclesUsed = Instruction.ld_H_D();
			break;
			case 0x63:
				cyclesUsed = Instruction.ld_H_E();
			break;
			case 0x64:
				cyclesUsed = Instruction.ld_H_H();
			break;
			case 0x65:
				cyclesUsed = Instruction.ld_H_L();
			break;
			case 0x66:
				cyclesUsed = Instruction.ld_H_$HL();
			break;
			case 0x68:
				cyclesUsed = Instruction.ld_L_B();
			break;
			case 0x69:
				cyclesUsed = Instruction.ld_L_C();
			break;
			case 0x6A:
				cyclesUsed = Instruction.ld_L_D();
			break;
			case 0x6B:
				cyclesUsed = Instruction.ld_L_E();
			break;
			case 0x6C:
				cyclesUsed = Instruction.ld_L_H();
			break;
			case 0x6D:
				cyclesUsed = Instruction.ld_L_L();
			break;
			case 0x6E:
				cyclesUsed = Instruction.ld_L_$HL();
			break;
			case 0x70:
				cyclesUsed = Instruction.ld_$HL_B();
			break;
			case 0x71:
				cyclesUsed = Instruction.ld_$HL_C();
			break;
			case 0x72:
				cyclesUsed = Instruction.ld_$HL_D();
			break;
			case 0x73:
				cyclesUsed = Instruction.ld_$HL_E();
			break;
			case 0x74:
				cyclesUsed = Instruction.ld_$HL_H();
			break;
			case 0x75:
				cyclesUsed = Instruction.ld_$HL_L();
			break;
			case 0x78:
				cyclesUsed = Instruction.ld_A_B();
			break;
			case 0x79:
				cyclesUsed = Instruction.ld_A_C();
			break;
			case 0x7A:
				cyclesUsed = Instruction.ld_A_D();
			break;
			case 0x7B:
				cyclesUsed = Instruction.ld_A_E();
			break;
			case 0x7C:
				cyclesUsed = Instruction.ld_A_H();
			break;
			case 0x7D:
				cyclesUsed = Instruction.ld_A_L();
			break;
			case 0x7E:
				cyclesUsed = Instruction.ld_A_$HL();
			break;
			case 0x7F:
				cyclesUsed = Instruction.ld_A_A();
			break;
			case 0x87:
				cyclesUsed = Instruction.add_A_A();
			break;
			case 0xA8:
				cyclesUsed = Instruction.xor_B();
			break;
			case 0xA9:
				cyclesUsed = Instruction.xor_C();
			break;
			case 0xAA:
				cyclesUsed = Instruction.xor_D();
			break;
			case 0xAB:
				cyclesUsed = Instruction.xor_E();
			break;
			case 0xAC:
				cyclesUsed = Instruction.xor_H();
			break;
			case 0xAD:
				cyclesUsed = Instruction.xor_L();
			break;
			case 0xAE:
				cyclesUsed = Instruction.xor_$HL();
			break;
			case 0xAF:
				cyclesUsed = Instruction.xor_A();
			break;
			case 0xC3:
				cyclesUsed = Instruction.jp_nn();
			break;
			case 0xEE:
				cyclesUsed = Instruction.xor_n();
			break;
		}

		nextCycle += (cyclesUsed * INSTR_TIME_STEP);
	}
}