/*

What needs to happen:

*/

public class Memory
{
	//debug switches
	private static final boolean DEBUG_INV_MEM = false;

	public static void reset()
	{
		InternalRAM.reset();
		SpriteAttribMemory.reset();
		//IO.reset();
		Interrupt.reset();
	}

	public static int read(int address)
	{
		//System.out.printf("DEBUG: Memory read: 0x%04X\n", address);
		int data = 0;
		if(address < 0x8000)//Cartrige ROM
		{
			data = Cartridge.read(address);
		}
		else if(address < 0xA000)//VRAM
		{
			data = VRAM.read(address);
		}
		else if(address < 0xC000)//Cartrige RAM
		{
			data = Cartridge.read(address);
			System.out.printf("DEBUG: Tried reading from unimplemented Cart RAM 0x%04X\n", address);
		}
		else if(address < 0xFE00)//Both workRAM banks + mirror
		{
			data = InternalRAM.read(address);
		}
		else if(address < 0xFEA0)//OAM
		{
			data = SpriteAttribMemory.read(address);
		}
		else if(address < 0xFF00)//Not useable
		{
			if(DEBUG_INV_MEM)
			{
				System.out.printf("DEBUG: Tried reading invalid memory address: 0x%04X\n" , address);
				Register.dumpRegisters();
			}

			data = 0x00;
		}
		else if(address < 0xFF80)//I/0 Ports
		{
			data = IO.read(address);
		}
		else if(address < 0xFFFF)//High RAM
		{
			data = InternalRAM.read(address);
		}
		else if(address == 0xFFFF)//Internal Enable Register
		{
			data = Interrupt.read();
		}
		else
		{
			System.out.printf("DEBUG: Something is wrong with the memory manager, None of the modules were selected address: 0x%04X\n", address);
		}

		return data;
	}

	public static void write(int address, int data)
		{
			if(address < 0x8000)//Cartrige ROM
			{
				Cartridge.write(address, data);
			}
			else if(address < 0xA000)//VRAM
			{
				VRAM.write(address, data);
			}
			else if(address < 0xC000)//Cartrige RAM
			{
				Cartridge.write(address, data);
			}
			else if(address < 0xFE00)//Both workRAM banks + mirror
			{
				InternalRAM.write(address, data);
			}
			else if(address < 0xFEA0)//OAM
			{
				SpriteAttribMemory.write(address, data);
			}
			else if(address < 0xFF00)//Not useable
			{
				if(DEBUG_INV_MEM)
				{
					System.out.printf("DEBUG: Tried writing invalid memory address: 0x%04X\n" , address);
					Register.dumpRegisters();
				}

			}
			else if(address < 0xFF80)//I/0 Ports
			{
				IO.write(address, data);
			}
			else if(address < 0xFFFF)//High RAM
			{
				InternalRAM.write(address, data);
			}
			else if(address == 0xFFFF)//Internal Enable Register
			{
				Interrupt.write(data);
			}
			else
			{
				System.out.printf("DEBUG: Something is wrong with the memory manager, None of the modules were selected address: 0x%04X\n", address);
			}
	}

	public static void dumpStack(int number)
	{
		int sp = Register.readSP();
		System.out.println("DEBUG: Dumping stack\n");

		for(int x = number; x > number; x--)
		{
			if(x == 0)
			{
				System.out.print("\t>");
			}
			else
			{
				System.out.print("\t ");
			}
			int address = sp + (x * 2);
			System.out.printf("0x%04X: %02X%02X\n", address, Memory.read(address), Memory.read(address + 1));
		}
	}
}