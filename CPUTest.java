import java.util.Scanner;
import java.io.IOException;

public class CPUTest
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("CPUTest");
		System.out.println("Select Rom");

		//Select Test ROM for testing CPU
		try
		{
			Cartridge.selectROM();
		}
		catch(IOException ioe)
		{
			System.out.println("Caught exception");
		}

		//reset CPU
		CPU.reset();

		while(true)
		{
			Register.dumpRegisters();
			System.out.println("Hit enter to execute next instruction");
			scan.nextLine();
			CPU.machineCycle();
		}
	}
}