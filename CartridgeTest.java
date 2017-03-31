import java.util.Scanner;

public class CartridgeTest
{
	public static void test()
	{
		int forceMbcType = Cartridge.MBC_MBC1;

		boolean exit = false;
		char inputChar;
		Scanner scan = new Scanner(System.in);

		int oldMbcType = Cartridge.mbc;
		Cartridge.mbc = forceMbcType;
		System.out.println("\tCartridge Test\n");
		System.out.println("Press Read\nWrite\neXit");
		while(!exit)
		{
			System.out.print("rwx>");
			inputChar = scan.next().charAt(0);
			switch(inputChar)
			{
				case 'r':
				case 'R':
					readTest();
					break;
				case 'w':
				case 'W':
					writeTest();
					break;
				case 'x':
				case 'X':
				case 'e':
				case 'E':
					exit = true;
					break;
			}
		}
	}

	public static void readTest()
	{
		Scanner scan = new Scanner(System.in);
		int address;

		System.out.print("Enter the address that you wish to read from in hex: 0x");
		address = scan.nextInt(16);
		System.out.printf("The address 0x%04X contains 0x%02X\n", address, Cartridge.read(address));
	}

	public static void writeTest()
	{
		Scanner scan = new Scanner(System.in);
		int address;
		int data;

		System.out.print("Enter the address that you wish to write to in hex: 0x");
		address = scan.nextInt(16);
		System.out.printf("Enter the data that you wish to write to 0x%04X in hex: 0x", address);
		data = scan.nextInt(16);
		Cartridge.write(address, data);
		System.out.printf("The address 0x%04X contains 0x%02X\n", address, Cartridge.read(address));
	}
}