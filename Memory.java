/*

What needs to happen:
	*Implement ROM.read()/write() when ROM class is ready
	*Change ROM & ExternalRAM classes to Cartridge class

*/

public class Memory
{
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
			//data = Cartridge.read(address);
		}
		else if(address < 0xFE00)//Both workRAM banks + mirror
		{
			//data = InternalRAM.read(address);
		}
		else if(address < 0xFEA0)//OAM
		{
			//data = SprintAttribMemory.read(address);
		}
		else if(address < 0xFF00)//Not useable
		{
			System.out.printf("DEBUG: Tried accessing invalid memory address: 0x%04X\n" , address);
			data = 0xFF;
		}
		else if(address < 0xFF80)//I/0 Ports
		{
			data = IO.read(address);
		}
		else if(address < 0xFFFF)//High RAM
		{
			//data = InternalRAM.read(address);
		}
		else if(address == 0xFFFF)//Internal Enable Register
		{
			//data = Interrupt.read(address);
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
				//InternalRAM.write(address, data);
			}
			else if(address < 0xFEA0)//OAM
			{
				//SprintAttribMemory.write(address, data);
			}
			else if(address < 0xFF00)//Not useable
			{
				System.out.printf("DEBUG: Tried accessing invalid memory address: 0x%04X\n" , address);
			}
			else if(address < 0xFF80)//I/0 Ports
			{
				IO.write(address, data);
			}
			else if(address < 0xFFFF)//High RAM
			{
				//InternalRAM.write(address, data);
			}
			else if(address == 0xFFFF)//Internal Enable Register
			{
				//Interrupt.write(address, data);
			}
			else
			{
				System.out.printf("DEBUG: Something is wrong with the memory manager, None of the modules were selected address: 0x%04X\n", address);
			}
	}
}