/* 	Notes:

	clock timings:
		Frequency: 4194304 HZ
		Period: 238.419ns
		Instruction time: 953.676ns

*/

import java.lang.System; //used for System.nanoTime()

import java.util.Timer;
import java.util.TimerTask;

public class CPU
{
	public static int breakpointAddress = 0xFFFF;

	private static volatile boolean running = false;
	private static volatile boolean dontExit = true;

	public static int clock = 0;

	private static long nextCycle = 0;

	private static final int INSTR_TIME_STEP = 954;

	public static boolean nextIME = false;

	private Timer cpuTimer;

	class CPUTimer extends TimerTask
	{
		public void run()
		{
			CPU.update();
		}
	}

	public void start()
	{
		cpuTimer = new Timer();
		running = true;
		cpuTimer.schedule(new CPUTimer(), 0, 1);
	}

	public static void pause()
	{
		running = false;
	}

	public static void unpause()
	{
		running = true;
		nextCycle = System.nanoTime() + INSTR_TIME_STEP;
	}


	public static void update()
	{
		if(running)
		{
			//used to check if time to execute next machine instruction
			while((System.nanoTime() > nextCycle) && running)
			{
				if(!Interrupt.checkForInterrupts())
				{
					clock += machineCycle();
				}
				else
				{
					nextCycle += (5 * INSTR_TIME_STEP);
					clock += 20;
				}
			}
		}
	}

	public static void step()
	{
		if(!Interrupt.checkForInterrupts())
		{
			clock += machineCycle();
		}
		else
		{
			nextCycle += (5 * INSTR_TIME_STEP);
			clock += 20;
		}
	}

	public static void reset()
	{
		//reset memory
		Memory.reset();
		//reset registers
		Register.writeAF(0x01B0);
		Register.writeBC(0x0013);
		Register.writeDE(0x00D8);
		Register.writeHL(0x014D);
		Register.writeSP(0xFFFE);
		Register.writePC(0x0100);
		//reset cartridge?
		//reset video
		VRAM.reset();
		//reset sound

		//set initial Instruction time
		nextCycle = System.nanoTime();
		nextCycle += INSTR_TIME_STEP;
	}

	public static int machineCycle()
	{
		int cyclesUsed = 0;
		int instruction = 0;

		Interrupt.IME = nextIME;

		if(Register.readPC() == breakpointAddress)
		{
			System.out.printf("Breakpoint reached: 0x%04X\n", Register.readPC());
			Register.dumpRegisters();
			pause();
		}

		//fetch
		instruction = Memory.read(Register.readPC());
		//System.out.printf("\nDEBUG: PC=0x%04X\n", Register.readPC());

		//decode/execute
		switch(instruction)
		{
			case 0x00:
				cyclesUsed = Instruction.nop();
			break;
			case 0x01:
				cyclesUsed = Instruction.ld_BC_nn();
			break;
			case 0x02:
				cyclesUsed = Instruction.ld_$BC_A();
			break;
			case 0x03:
				cyclesUsed = Instruction.inc_BC();
			break;
			case 0x04:
				cyclesUsed = Instruction.inc_B();
			break;
			case 0x05:
				cyclesUsed = Instruction.dec_B();
			break;
			case 0x06:
				cyclesUsed = Instruction.ld_B_n();
			break;
			case 0x09:
				cyclesUsed = Instruction.add_HL_BC();
			break;
			case 0x0A:
				cyclesUsed = Instruction.ld_A_$BC();
			break;
			case 0x0B:
				cyclesUsed = Instruction.dec_BC();
			break;
			case 0x0C:
				cyclesUsed = Instruction.inc_C();
			break;
			case 0x0D:
				cyclesUsed = Instruction.dec_C();
			break;
			case 0x0E:
				cyclesUsed = Instruction.ld_C_n();
			break;
			case 0x11:
				cyclesUsed = Instruction.ld_DE_nn();
			break;
			case 0x12:
				cyclesUsed = Instruction.ld_$DE_A();
			break;
			case 0x13:
				cyclesUsed = Instruction.inc_DE();
			break;
			case 0x14:
				cyclesUsed = Instruction.inc_D();
			break;
			case 0x15:
				cyclesUsed = Instruction.dec_D();
			break;
			case 0x16:
				cyclesUsed = Instruction.ld_D_n();
			break;
			case 0x18:
				cyclesUsed = Instruction.jr_n();
			break;
			case 0x19:
				cyclesUsed = Instruction.add_HL_DE();
			break;
			case 0x1A:
				cyclesUsed = Instruction.ld_A_$DE();
			break;
			case 0x1B:
				cyclesUsed = Instruction.dec_DE();
			break;
			case 0x1C:
				cyclesUsed = Instruction.inc_E();
			break;
			case 0x1D:
				cyclesUsed = Instruction.dec_E();
			break;
			case 0x1E:
				cyclesUsed = Instruction.ld_E_n();
			break;
			case 0x20:
				cyclesUsed = Instruction.jr_nz_n();
			break;
			case 0x21:
				cyclesUsed = Instruction.ld_HL_nn();
			break;
			case 0x22:
				cyclesUsed = Instruction.ldi_$HL_A();
			break;
			case 0x23:
				cyclesUsed = Instruction.inc_HL();
			break;
			case 0x24:
				cyclesUsed = Instruction.inc_H();
			break;
			case 0x25:
				cyclesUsed = Instruction.dec_H();
			break;
			case 0x26:
				cyclesUsed = Instruction.ld_H_n();
			break;
			case 0x28:
				cyclesUsed = Instruction.jr_z_n();
			break;
			case 0x29:
				cyclesUsed = Instruction.add_HL_HL();
			break;
			case 0x2A:
				cyclesUsed = Instruction.ldi_A_$HL();
			break;
			case 0x2B:
				cyclesUsed = Instruction.dec_HL();
			break;
			case 0x2C:
				cyclesUsed = Instruction.inc_L();
			break;
			case 0x2D:
				cyclesUsed = Instruction.dec_L();
			break;
			case 0x2E:
				cyclesUsed = Instruction.ld_L_n();
			break;
			case 0x2F:
				cyclesUsed = Instruction.cpl();
			break;
			case 0x30:
				cyclesUsed = Instruction.jr_nc_n();
			break;
			case 0x31:
				cyclesUsed = Instruction.ld_SP_nn();
			break;
			case 0x32:
				cyclesUsed = Instruction.ldd_$HL_A();
			break;
			case 0x33:
				cyclesUsed = Instruction.inc_SP();
			break;
			case 0x34:
				cyclesUsed = Instruction.inc_$HL();
			break;
			case 0x35:
				cyclesUsed = Instruction.dec_$HL();
			break;
			case 0x36:
				cyclesUsed = Instruction.ld_$HL_n();
			break;
			case 0x38:
				cyclesUsed = Instruction.jr_c_n();
			break;
			case 0x39:
				cyclesUsed = Instruction.add_HL_SP();
			break;
			case 0x3A:
				cyclesUsed = Instruction.ldd_A_$HL();
			break;
			case 0x3B:
				cyclesUsed = Instruction.dec_SP();
			break;
			case 0x3C:
				cyclesUsed = Instruction.inc_A();
			break;
			case 0x3D:
				cyclesUsed = Instruction.dec_A();
			break;
			case 0x3E:
				cyclesUsed = Instruction.ld_A_n();
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
			case 0x47:
				cyclesUsed = Instruction.ld_B_A();
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
			case 0x4F:
				cyclesUsed = Instruction.ld_C_A();
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
			case 0x57:
				cyclesUsed = Instruction.ld_D_A();
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
			case 0x5F:
				cyclesUsed = Instruction.ld_E_A();
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
			case 0x67:
				cyclesUsed = Instruction.ld_H_A();
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
			case 0x6F:
				cyclesUsed = Instruction.ld_L_A();
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
			case 0x77:
				cyclesUsed = Instruction.ld_$HL_A();
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
			case 0x80:
				cyclesUsed = Instruction.add_A_B();
			break;
			case 0x81:
				cyclesUsed = Instruction.add_A_C();
			break;
			case 0x82:
				cyclesUsed = Instruction.add_A_D();
			break;
			case 0x83:
				cyclesUsed = Instruction.add_A_E();
			break;
			case 0x84:
				cyclesUsed = Instruction.add_A_H();
			break;
			case 0x85:
				cyclesUsed = Instruction.add_A_L();
			break;
			case 0x86:
				cyclesUsed = Instruction.add_A_$HL();
			break;
			case 0x87:
				cyclesUsed = Instruction.add_A_A();
			break;
			case 0x90:
				cyclesUsed = Instruction.sub_A_B();
			break;
			case 0x91:
				cyclesUsed = Instruction.sub_A_C();
			break;
			case 0x92:
				cyclesUsed = Instruction.sub_A_D();
			break;
			case 0x93:
				cyclesUsed = Instruction.sub_A_E();
			break;
			case 0x94:
				cyclesUsed = Instruction.sub_A_H();
			break;
			case 0x95:
				cyclesUsed = Instruction.sub_A_L();
			break;
			case 0x96:
				cyclesUsed = Instruction.sub_A_$HL();
			break;
			case 0x97:
				cyclesUsed = Instruction.sub_A_A();
			break;
			case 0xA0:
				cyclesUsed = Instruction.and_B();
			break;
			case 0xA1:
				cyclesUsed = Instruction.and_C();
			break;
			case 0xA2:
				cyclesUsed = Instruction.and_D();
			break;
			case 0xA3:
				cyclesUsed = Instruction.and_E();
			break;
			case 0xA4:
				cyclesUsed = Instruction.and_H();
			break;
			case 0xA5:
				cyclesUsed = Instruction.and_L();
			break;
			case 0xA6:
				cyclesUsed = Instruction.and_$HL();
			break;
			case 0xA7:
				cyclesUsed = Instruction.and_A();
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
			case 0xB0:
				cyclesUsed = Instruction.or_B();
			break;
			case 0xB1:
				cyclesUsed = Instruction.or_C();
			break;
			case 0xB2:
				cyclesUsed = Instruction.or_D();
			break;
			case 0xB3:
				cyclesUsed = Instruction.or_E();
			break;
			case 0xB4:
				cyclesUsed = Instruction.or_H();
			break;
			case 0xB5:
				cyclesUsed = Instruction.or_L();
			break;
			case 0xB6:
				cyclesUsed = Instruction.or_$HL();
			break;
			case 0xB7:
				cyclesUsed = Instruction.or_A();
			break;
			case 0xB8:
				cyclesUsed = Instruction.cp_B();
			break;
			case 0xB9:
				cyclesUsed = Instruction.cp_C();
			break;
			case 0xBA:
				cyclesUsed = Instruction.cp_D();
			break;
			case 0xBB:
				cyclesUsed = Instruction.cp_E();
			break;
			case 0xBC:
				cyclesUsed = Instruction.cp_H();
			break;
			case 0xBD:
				cyclesUsed = Instruction.cp_L();
			break;
			case 0xBE:
				cyclesUsed = Instruction.cp_$HL();
			break;
			case 0xBF:
				cyclesUsed = Instruction.cp_A();
			break;
			case 0xC0:
				cyclesUsed = Instruction.ret_nz();
			break;
			case 0xC1:
				cyclesUsed = Instruction.pop_BC();
			break;
			case 0xC2:
				cyclesUsed = Instruction.jp_nz_nn();
			break;
			case 0xC3:
				cyclesUsed = Instruction.jp_nn();
			break;
			case 0xC4:
				cyclesUsed = Instruction.call_nz_nn();
			break;
			case 0xC5:
				cyclesUsed = Instruction.push_BC();
			break;
			case 0xC6:
				cyclesUsed = Instruction.add_A_n();
			break;
			case 0xC7:
				cyclesUsed = Instruction.rst_00();
			break;
			case 0xC8:
				cyclesUsed = Instruction.ret_z();
			break;
			case 0xC9:
				cyclesUsed = Instruction.ret();
			break;
			case 0xCA:
				cyclesUsed = Instruction.jp_z_nn();
			break;
			case 0xCB:
				int subcode = Memory.read(Register.readPC() + 1);
				switch(subcode)
				{
					case 0x30:
						cyclesUsed = Instruction.swap_B();
					break;
					case 0x31:
						cyclesUsed = Instruction.swap_C();
					break;
					case 0x32:
						cyclesUsed = Instruction.swap_D();
					break;
					case 0x33:
						cyclesUsed = Instruction.swap_E();
					break;
					case 0x34:
						cyclesUsed = Instruction.swap_H();
					break;
					case 0x35:
						cyclesUsed = Instruction.swap_L();
					break;
					case 0x36:
						cyclesUsed = Instruction.swap_$HL();
					break;
					case 0x37:
						cyclesUsed = Instruction.swap_A();
					break;
					case 0x38:
						cyclesUsed = Instruction.srl_B();
					break;
					case 0x39:
						cyclesUsed = Instruction.srl_C();
					break;
					case 0x3A:
						cyclesUsed = Instruction.srl_D();
					break;
					case 0x3B:
						cyclesUsed = Instruction.srl_E();
					break;
					case 0x3C:
						cyclesUsed = Instruction.srl_H();
					break;
					case 0x3D:
						cyclesUsed = Instruction.srl_L();
					break;
					case 0x3E:
						cyclesUsed = Instruction.srl_$HL();
					break;
					case 0x3F:
						cyclesUsed = Instruction.srl_A();
					break;
					case 0x40:
						cyclesUsed = Instruction.bit_0_B();
					break;
					case 0x41:
						cyclesUsed = Instruction.bit_0_C();
					break;
					case 0x42:
						cyclesUsed = Instruction.bit_0_D();
					break;
					case 0x43:
						cyclesUsed = Instruction.bit_0_E();
					break;
					case 0x44:
						cyclesUsed = Instruction.bit_0_H();
					break;
					case 0x45:
						cyclesUsed = Instruction.bit_0_L();
					break;
					case 0x46:
						cyclesUsed = Instruction.bit_0_$HL();
					break;
					case 0x47:
						cyclesUsed = Instruction.bit_0_A();
					break;
					case 0x48:
						cyclesUsed = Instruction.bit_1_B();
					break;
					case 0x49:
						cyclesUsed = Instruction.bit_1_C();
					break;
					case 0x4A:
						cyclesUsed = Instruction.bit_1_D();
					break;
					case 0x4B:
						cyclesUsed = Instruction.bit_1_E();
					break;
					case 0x4C:
						cyclesUsed = Instruction.bit_1_H();
					break;
					case 0x4D:
						cyclesUsed = Instruction.bit_1_L();
					break;
					case 0x4E:
						cyclesUsed = Instruction.bit_1_$HL();
					break;
					case 0x4F:
						cyclesUsed = Instruction.bit_1_A();
					break;
					case 0x50:
						cyclesUsed = Instruction.bit_2_B();
					break;
					case 0x51:
						cyclesUsed = Instruction.bit_2_C();
					break;
					case 0x52:
						cyclesUsed = Instruction.bit_2_D();
					break;
					case 0x53:
						cyclesUsed = Instruction.bit_2_E();
					break;
					case 0x54:
						cyclesUsed = Instruction.bit_2_H();
					break;
					case 0x55:
						cyclesUsed = Instruction.bit_2_L();
					break;
					case 0x56:
						cyclesUsed = Instruction.bit_2_$HL();
					break;
					case 0x57:
						cyclesUsed = Instruction.bit_2_A();
					break;
					case 0x58:
						cyclesUsed = Instruction.bit_3_B();
					break;
					case 0x59:
						cyclesUsed = Instruction.bit_3_C();
					break;
					case 0x5A:
						cyclesUsed = Instruction.bit_3_D();
					break;
					case 0x5B:
						cyclesUsed = Instruction.bit_3_E();
					break;
					case 0x5C:
						cyclesUsed = Instruction.bit_3_H();
					break;
					case 0x5D:
						cyclesUsed = Instruction.bit_3_L();
					break;
					case 0x5E:
						cyclesUsed = Instruction.bit_3_$HL();
					break;
					case 0x5F:
						cyclesUsed = Instruction.bit_1_A();
					break;
					case 0x60:
						cyclesUsed = Instruction.bit_4_B();
					break;
					case 0x61:
						cyclesUsed = Instruction.bit_4_C();
					break;
					case 0x62:
						cyclesUsed = Instruction.bit_4_D();
					break;
					case 0x63:
						cyclesUsed = Instruction.bit_4_E();
					break;
					case 0x64:
						cyclesUsed = Instruction.bit_4_H();
					break;
					case 0x65:
						cyclesUsed = Instruction.bit_4_L();
					break;
					case 0x66:
						cyclesUsed = Instruction.bit_4_$HL();
					break;
					case 0x67:
						cyclesUsed = Instruction.bit_4_A();
					break;
					case 0x68:
						cyclesUsed = Instruction.bit_5_B();
					break;
					case 0x69:
						cyclesUsed = Instruction.bit_5_C();
					break;
					case 0x6A:
						cyclesUsed = Instruction.bit_5_D();
					break;
					case 0x6B:
						cyclesUsed = Instruction.bit_5_E();
					break;
					case 0x6C:
						cyclesUsed = Instruction.bit_5_H();
					break;
					case 0x6D:
						cyclesUsed = Instruction.bit_5_L();
					break;
					case 0x6E:
						cyclesUsed = Instruction.bit_5_$HL();
					break;
					case 0x6F:
						cyclesUsed = Instruction.bit_5_A();
					break;
					case 0x70:
						cyclesUsed = Instruction.bit_6_B();
					break;
					case 0x71:
						cyclesUsed = Instruction.bit_6_C();
					break;
					case 0x72:
						cyclesUsed = Instruction.bit_6_D();
					break;
					case 0x73:
						cyclesUsed = Instruction.bit_6_E();
					break;
					case 0x74:
						cyclesUsed = Instruction.bit_6_H();
					break;
					case 0x75:
						cyclesUsed = Instruction.bit_6_L();
					break;
					case 0x76:
						cyclesUsed = Instruction.bit_6_$HL();
					break;
					case 0x77:
						cyclesUsed = Instruction.bit_6_A();
					break;
					case 0x78:
						cyclesUsed = Instruction.bit_7_B();
					break;
					case 0x79:
						cyclesUsed = Instruction.bit_7_C();
					break;
					case 0x7A:
						cyclesUsed = Instruction.bit_7_D();
					break;
					case 0x7B:
						cyclesUsed = Instruction.bit_7_E();
					break;
					case 0x7C:
						cyclesUsed = Instruction.bit_7_H();
					break;
					case 0x7D:
						cyclesUsed = Instruction.bit_7_L();
					break;
					case 0x7E:
						cyclesUsed = Instruction.bit_7_$HL();
					break;
					case 0x7F:
						cyclesUsed = Instruction.bit_7_A();
					break;
					case 0x80:
						cyclesUsed = Instruction.res_0_B();
					break;
					case 0x81:
						cyclesUsed = Instruction.res_0_C();
					break;
					case 0x82:
						cyclesUsed = Instruction.res_0_D();
					break;
					case 0x83:
						cyclesUsed = Instruction.res_0_E();
					break;
					case 0x84:
						cyclesUsed = Instruction.res_0_H();
					break;
					case 0x85:
						cyclesUsed = Instruction.res_0_L();
					break;
					case 0x86:
						cyclesUsed = Instruction.res_0_$HL();
					break;
					case 0x87:
						cyclesUsed = Instruction.res_0_A();
					break;
					case 0x88:
						cyclesUsed = Instruction.res_1_B();
					break;
					case 0x89:
						cyclesUsed = Instruction.res_1_C();
					break;
					case 0x8A:
						cyclesUsed = Instruction.res_1_D();
					break;
					case 0x8B:
						cyclesUsed = Instruction.res_1_E();
					break;
					case 0x8C:
						cyclesUsed = Instruction.res_1_H();
					break;
					case 0x8D:
						cyclesUsed = Instruction.res_1_L();
					break;
					case 0x8E:
						cyclesUsed = Instruction.res_1_$HL();
					break;
					case 0x8F:
						cyclesUsed = Instruction.res_1_A();
					break;
					case 0x90:
						cyclesUsed = Instruction.res_2_B();
					break;
					case 0x91:
						cyclesUsed = Instruction.res_2_C();
					break;
					case 0x92:
						cyclesUsed = Instruction.res_2_D();
					break;
					case 0x93:
						cyclesUsed = Instruction.res_2_E();
					break;
					case 0x94:
						cyclesUsed = Instruction.res_2_H();
					break;
					case 0x95:
						cyclesUsed = Instruction.res_2_L();
					break;
					case 0x96:
						cyclesUsed = Instruction.res_2_$HL();
					break;
					case 0x97:
						cyclesUsed = Instruction.res_2_A();
					break;
					case 0x98:
						cyclesUsed = Instruction.res_3_B();
					break;
					case 0x99:
						cyclesUsed = Instruction.res_3_C();
					break;
					case 0x9A:
						cyclesUsed = Instruction.res_3_D();
					break;
					case 0x9B:
						cyclesUsed = Instruction.res_3_E();
					break;
					case 0x9C:
						cyclesUsed = Instruction.res_3_H();
					break;
					case 0x9D:
						cyclesUsed = Instruction.res_3_L();
					break;
					case 0x9E:
						cyclesUsed = Instruction.res_3_$HL();
					break;
					case 0x9F:
						cyclesUsed = Instruction.res_3_A();
					break;
					case 0xA0:
						cyclesUsed = Instruction.res_4_B();
					break;
					case 0xA1:
						cyclesUsed = Instruction.res_4_C();
					break;
					case 0xA2:
						cyclesUsed = Instruction.res_4_D();
					break;
					case 0xA3:
						cyclesUsed = Instruction.res_4_E();
					break;
					case 0xA4:
						cyclesUsed = Instruction.res_4_H();
					break;
					case 0xA5:
						cyclesUsed = Instruction.res_4_L();
					break;
					case 0xA6:
						cyclesUsed = Instruction.res_4_$HL();
					break;
					case 0xA7:
						cyclesUsed = Instruction.res_4_A();
					break;
					case 0xA8:
						cyclesUsed = Instruction.res_5_B();
					break;
					case 0xA9:
						cyclesUsed = Instruction.res_5_C();
					break;
					case 0xAA:
						cyclesUsed = Instruction.res_5_D();
					break;
					case 0xAB:
						cyclesUsed = Instruction.res_5_E();
					break;
					case 0xAC:
						cyclesUsed = Instruction.res_5_H();
					break;
					case 0xAD:
						cyclesUsed = Instruction.res_5_L();
					break;
					case 0xAE:
						cyclesUsed = Instruction.res_5_$HL();
					break;
					case 0xAF:
						cyclesUsed = Instruction.res_5_A();
					break;
					case 0xB0:
						cyclesUsed = Instruction.res_6_B();
					break;
					case 0xB1:
						cyclesUsed = Instruction.res_6_C();
					break;
					case 0xB2:
						cyclesUsed = Instruction.res_6_D();
					break;
					case 0xB3:
						cyclesUsed = Instruction.res_6_E();
					break;
					case 0xB4:
						cyclesUsed = Instruction.res_6_H();
					break;
					case 0xB5:
						cyclesUsed = Instruction.res_6_L();
					break;
					case 0xB6:
						cyclesUsed = Instruction.res_6_$HL();
					break;
					case 0xB7:
						cyclesUsed = Instruction.res_6_A();
					break;
					case 0xB8:
						cyclesUsed = Instruction.res_7_B();
					break;
					case 0xB9:
						cyclesUsed = Instruction.res_7_C();
					break;
					case 0xBA:
						cyclesUsed = Instruction.res_7_D();
					break;
					case 0xBB:
						cyclesUsed = Instruction.res_7_E();
					break;
					case 0xBC:
						cyclesUsed = Instruction.res_7_H();
					break;
					case 0xBD:
						cyclesUsed = Instruction.res_7_L();
					break;
					case 0xBE:
						cyclesUsed = Instruction.res_7_$HL();
					break;
					case 0xBF:
						cyclesUsed = Instruction.res_7_A();
					break;
					default:
						System.out.printf("\nERROR: Unidentified Opcode 0x%02X, 0x%02X\n", instruction, subcode);
						Register.dumpRegisters();
						pause();
					break;
				}
			break;
			case 0xCC:
				cyclesUsed = Instruction.call_z_nn();
			break;
			case 0xCD:
				cyclesUsed = Instruction.call_nn();
			break;
			case 0xCF:
				cyclesUsed = Instruction.rst_08();
			break;
			case 0xD0:
				cyclesUsed = Instruction.ret_nc();
			break;
			case 0xD1:
				cyclesUsed = Instruction.pop_DE();
			break;
			case 0xD2:
				cyclesUsed = Instruction.jp_nc_nn();
			break;
			case 0xD4:
				cyclesUsed = Instruction.call_nc_nn();
			break;
			case 0xD5:
				cyclesUsed = Instruction.push_DE();
			break;
			case 0xD6:
				cyclesUsed = Instruction.sub_A_n();
			break;
			case 0xD7:
				cyclesUsed = Instruction.rst_10();
			break;
			case 0xD8:
				cyclesUsed = Instruction.ret_c();
			break;
			case 0xD9:
				cyclesUsed = Instruction.reti();
			break;
			case 0xDA:
				cyclesUsed = Instruction.jp_c_nn();
			break;
			case 0xDC:
				cyclesUsed = Instruction.call_c_nn();
			break;
			case 0xDF:
				cyclesUsed = Instruction.rst_18();
			break;
			case 0xE0:
				cyclesUsed = Instruction.ldh_$n_A();
			break;
			case 0xE1:
				cyclesUsed = Instruction.pop_HL();
			break;
			case 0xE2:
				cyclesUsed = Instruction.ld_$C_A();
			break;
			case 0xE5:
				cyclesUsed = Instruction.push_HL();
			break;
			case 0xE6:
				cyclesUsed = Instruction.and_n();
			break;
			case 0xE7:
				cyclesUsed = Instruction.rst_20();
			break;
			case 0xE9:
				cyclesUsed = Instruction.jp_$HL();
			break;
			case 0xEA:
				cyclesUsed = Instruction.ld_$nn_A();
			break;
			case 0xEE:
				cyclesUsed = Instruction.xor_n();
			break;
			case 0xEF:
				cyclesUsed = Instruction.rst_28();
			break;
			case 0xF0:
				cyclesUsed = Instruction.ldh_A_$n();
			break;
			case 0xF1:
				cyclesUsed = Instruction.pop_AF();
			break;
			case 0xF2:
				cyclesUsed = Instruction.ld_A_$C();
			break;
			case 0xF3:
				cyclesUsed = Instruction.di();
			break;
			case 0xF5:
				cyclesUsed = Instruction.push_AF();
			break;
			case 0xF6:
				cyclesUsed = Instruction.or_n();
			break;
			case 0xF7:
				cyclesUsed = Instruction.rst_30();
			break;
			case 0xFA:
				cyclesUsed = Instruction.ld_A_$nn();
			break;
			case 0xFB:
				cyclesUsed = Instruction.ei();
			break;
			case 0xFE:
				cyclesUsed = Instruction.cp_n();
			break;
			case 0xFF:
				cyclesUsed = Instruction.rst_38();
			break;
			default:
				System.out.printf("\nERROR: Unidentified Opcode 0x%02X\n", instruction);
				System.out.println("This is before the register dump.");
				Register.dumpRegisters();
				System.out.println("This is before the 'stack dump'");
				Memory.dumpStack(5);
				System.out.println("This is after the 'stack dump'.");
				pause();
			break;
		}

		nextCycle += (cyclesUsed * INSTR_TIME_STEP);
		return (cyclesUsed << 2);
	}
}