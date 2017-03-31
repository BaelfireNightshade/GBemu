/*

	Todo:
		1. Make File->ROMInfoMenuItem.

*/

import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.Thread;
import java.lang.InterruptedException;
public class GameboyEmu
{

	public static boolean running = false;

	public static CPU cpu = new CPU();

	public static JFrame frame;
	public static Screen screen;

	private static JMenuBar menuBar;

	private static JMenu fileMenu;
	private static JMenuItem selectRomMenuItem;
	private static JMenuItem exitMenuItem;

	private static JMenu runMenu;
	private static JMenuItem runMenuItem;
	private static JMenuItem pauseMenuItem;
	private static JMenuItem resetMenuItem;

	private static JMenu toolsMenu;
	private static JMenuItem debugMenuItem;

	private static JMenu helpMenu;
	private static JMenuItem aboutMenuItem;

	//Main program
	public static void main(String[]args)
	throws InterruptedException
	{
		System.out.println("Gameboy eMu");
		System.out.println("Created by Tad Parrish\n");

		if(args.length != 0)
		{
			if((args.length > 2) || args[0].equals("/?") || args[0].equals("-help") || args[0].equals("--help") || args[0].equals("/help") || args[0].equals("?") || args[0].equals("/h") || args[0].equals("-h"))
			{
				System.out.println("Usage: java GameboyEmu [PATH_TO_ROM [HEX_BREAKPOINT_ADDRESS]]\n");
				System.out.println("Controls:");
				System.out.println("Joypad\tKeyboard");
				System.out.println("up\tup");
				System.out.println("down\tdown");
				System.out.println("left\tleft");
				System.out.println("right\tright");
				System.out.println("A\tS");
				System.out.println("B\tA");
				System.out.println("Start\tX");
				System.out.println("Select\tZ");
				return;
			}
			if(args.length == 2)
			{
				CPU.breakpointAddress = Integer.parseInt(args[1], 16);
			}
		}
		frame = new JFrame("GBe\u03BC"); //Create frame for screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(Listeners.keypad);

		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		selectRomMenuItem = new JMenuItem("Open Rom");
		selectRomMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		selectRomMenuItem.addActionListener(Listeners.file_selectRom);
		fileMenu.add(selectRomMenuItem);

		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(Listeners.file_exit);
		fileMenu.add(exitMenuItem);

		runMenu = new JMenu("Run");
		menuBar.add(runMenu);

		runMenuItem = new JMenuItem("Run Emulation");
		runMenuItem.addActionListener(Listeners.run_run);
		runMenu.add(runMenuItem);

		pauseMenuItem = new JMenuItem("Pause");
		pauseMenuItem.addActionListener(Listeners.run_pause);
		runMenu.add(pauseMenuItem);

		resetMenuItem = new JMenuItem("Reset");
		resetMenuItem.addActionListener(Listeners.run_reset);
		runMenu.add(resetMenuItem);

		toolsMenu = new JMenu("Tools");
		menuBar.add(toolsMenu);

		debugMenuItem = new JMenuItem("Debugger");
		debugMenuItem.addActionListener(Listeners.tools_debug);
		toolsMenu.add(debugMenuItem);

		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		aboutMenuItem = new JMenuItem("About");
		helpMenu.add(aboutMenuItem);

		screen = new Screen();

		frame.getContentPane().add(screen);

		frame.setJMenuBar(menuBar);

		frame.pack();
		frame.setVisible(true);

		screen.testScreen();

		//if there is a file path to a rom in the arguments, open it
		if(args.length != 0)
		{
			try
			{
				Cartridge.openROM(args[0]);
			}
			catch(IOException ioe)
			{
				System.out.println("Caught exception");
			}
			GameboyEmu.frame.setTitle("GB\u03BC: " + Cartridge.title);
			GameboyEmu.screen.screenBlank();
			GameboyEmu.screen.loadNintendoLogo(8*7, 4*17);

			GameboyEmu.running = true;
		}
	}
}