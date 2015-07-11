/*
What needs to happen:
	*Create Memory Bank Controllers:
		*None	done
		*MBC1	done - passed testing
		*MBC2
		*MBC3
		*MBC5
		*HuC1?

In Progress:
*/
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.System;

public class Cartridge
{
	private static File file;
	private static int[] rom;

	private static int[] ram;

	public static String title = "";

	public static int mbc; //holds mbc type

	public static final int MBC_NONE = 0;
	public static final int MBC_MBC1 = 1;
	public static final int MBC_MBC2 = 2;
	public static final int MBC_MBC3 = 3;
	public static final int MBC_MBC5 = 5;
	public static final int MBC_HuC1 = 6;

	private static final int CART_TYPE_ADDRESS = 0x0147;
	private static final int ROM_SIZE_ADDRESS = 0x0148;
	private static final int RAM_SIZE_ADDRESS = 0x0149;

	private static int ROMBank = 1;
	private static int RAMBank = 0;

	private static int ramEnable = 0;
	private static int romRamSelect = 0;
	private static final int ROM = 0x00;
	private static final int RAM = 0x01;

	private static int RAMSize = 0;


	public static void selectROM() throws IOException
	{
		//ask the user for a rom
		final JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Gameboy Rom Images", "gb");
		fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(GameboyEmu.frame);

		//if it's a valid file, keep the file directory
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			file = fc.getSelectedFile();
		}
		else
		{
			System.out.println("DEBUG: Filechooser not happy.");
		}
		FileInputStream in = null;
		if(file != null)
		{
			try
			{
				in = new FileInputStream(file);
				int length = in.available();//get length of the rom file
				rom = new int[length];//make the rom array big enough to hold it.
				for(int address = 0; address < length; address++)
				{
					rom[address] = in.read();//copy from file to rom array
				}
			}
			finally
			{
				if(in != null)
				{
					in.close();//close the file if something goes wrong
				}
			}
		}

		//Close the file now that it's been loaded.
		if(in != null)
		{
			in.close();
		}

		//set the title of the window to include the title of the game
		String cartTitle = new String();
		for(int i = 0x134; i < 0x143; i++)
		{
			cartTitle = cartTitle + (char)read(i);
		}
		title = cartTitle;
		System.out.println("Cartridge Title: " + title);

		//set the size of RAM
		switch(rom[RAM_SIZE_ADDRESS])
		{
			case 0x00:
				RAMSize = 0;// No RAM
				break;
			case 0x01:
				RAMSize = 2 * 1024; // 2KBytes
				break;
			case 0x02:
				RAMSize = 8 * 1024; // 8KBytes
				break;
			case 0x03:
				RAMSize = 32 * 1024;
		}
		ram = new int[RAMSize];
		System.out.println("Number of RAM Banks: " + rom[RAM_SIZE_ADDRESS]);

		//set the MBC type
		switch(rom[CART_TYPE_ADDRESS])
		{
			case 0x00:
			case 0x08:
			case 0x09:
				mbc = MBC_NONE;
				System.out.println("Cartridge Type: MBC_NONE");
				break;
			case 0x01:
			case 0x02:
			case 0x03:
				mbc = MBC_MBC1;
				System.out.println("Cartridge Type: MBC_MBC1");
				break;
			case 0x05:
			case 0x06:
				mbc = MBC_MBC2;
				System.out.println("Cartridge Type: MBC_MBC2");
				break;
			case 0x0F:
			case 0x10:
			case 0x11:
			case 0x12:
			case 0x13:
				mbc = MBC_MBC3;
				System.out.println("Cartridge Type: MBC_MBC3");
				break;
			case 0x19:
			case 0x1A:
			case 0x1B:
			case 0x1C:
			case 0x1D:
			case 0x1E:
				mbc = MBC_MBC5;
				System.out.println("Cartridge Type: MBC_MBC5");
				break;
			case 0xFF:
				mbc = MBC_HuC1;
				System.out.println("Cartridge Type: MBC_HuC1");
				break;
			default:
				System.out.printf("DEBUG: Cartridge Type unknown. rom[0x0147]: %02X\n", rom[CART_TYPE_ADDRESS]);
		}
	}

	public static int read(int address)
	{
		if(mbc == MBC_NONE)
		{
			return rom[address];
		}
		else if(mbc == MBC_MBC1)
		{
			if(address < 0x4000)
			{
				return rom[address];
			}
			else if(address < 0x8000)
			{
				if((ROMBank & 0x1F) != 0x00)
				{
					if(romRamSelect == RAM)
					{
						return rom[(ROMBank & 0x1F) * 0x4000 + address - 0x4000];
					}
					else
					{
						return rom[(((ROMBank & 0x1F) | (RAMBank << 5)) * 0x4000) + address - 0x4000];
					}
				}
				else
				{
					return rom[address];
				}
			}
			else if((address >= 0xA000) && (address < 0xC000) && (ramEnable == 1))//reading from RAM
			{
				if(romRamSelect == ROM)
				{
					return ram[address - 0xA000];
				}
				else
				{
					return ram[(RAMBank * 8 * 1024) + (address - 0xA000)];
				}
			}
			else
			{
				return 0xFF;
			}
		}
		else
		{
			return 0xFF;
		}
	}

	public static void write(int address, int data)
	{
		if(mbc == MBC_NONE)
		{
			System.out.println("ERROR: Tried writing to ROM on MBC_NONE");
		}
		else if(mbc == MBC_MBC1)
		{
			if(address < 0x2000)
			{
				//RAM Enable
				if((data & 0x0F) == 0x0A)
				{
					ramEnable = 1;
					System.out.println("MBC1: Enabling RAM");
				}
				else
				{
					ramEnable = 0;
					System.out.println("MBC1: Disabling RAM");
				}
			}
			else if(address < 0x4000)
			{
				//lower 5 bits of ROM bank number (0x01 - 0x1F)
				ROMBank = data & 0xFF;
				System.out.printf("MBC1: Changing ROM bank number to 0x%02X", ROMBank);
			}
			else if(address < 0x6000)
			{
				//upper 2 bits ROM bank/RAM bank number
				RAMBank = data & 0xFF;
				System.out.printf("MBC1: Changing RAM bank number to 0x%02X", RAMBank);
			}
			else if(address < 0x8000)
			{
				//ROM/RAM select
				romRamSelect = data & 0x01;
				System.out.printf("MBC1: Changing ROM/RAM select to 0x%02X", romRamSelect);
			}
			else if((address >= 0xA000) && (address < 0xC000) && (ramEnable == 1))//writing to RAM
			{
				if(romRamSelect == ROM)
				{
					ram[address - 0xA000] = data & 0xFF;
					System.out.printf("MBC1: Writing to RAM address 0x%04X, 0x%02X", address, ram[address - 0xA000]);
				}
				else
				{
					ram[(RAMBank * 8 * 1024) + (address - 0xA000)] = data & 0xFF;
					System.out.printf("MBC1: Writing to RAM address 0x%04X, 0x%02X\n", address, ram[(RAMBank * 8 * 1024) + (address - 0xA000)]);
				}
			}
		}
	}

	public static void forceMBC(int newMbc)
	{
		mbc = newMbc;
	}
}