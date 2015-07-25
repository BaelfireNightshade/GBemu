/*

	Todo:
		2. Make File->ROMInfoMenuItem.
		1. Move actionListeners to their own class. ActionListeners maybe. (for cleanup)

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

	public static JFrame frame;
	public static Screen screen;

	private static JMenuBar menuBar;

	private static JMenu fileMenu;
	private static JMenuItem selectRomMenuItem;
	private static JMenuItem exitMenuItem;

	private static JMenu toolsMenu;
	private static JMenuItem emptyMenuItem;

	private static JMenu helpMenu;
	private static JMenuItem aboutMenuItem;

	//Main program
	public static void main(String[]args)
	throws InterruptedException
	{
		System.out.println("Gameboy eMu");
		System.out.println("Created by Tad Parrish\n");
		frame = new JFrame("GBe\u03BC"); //Create frame for screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		selectRomMenuItem = new JMenuItem("Open Rom");
		selectRomMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		selectRomMenuItem.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					try
					{
						Cartridge.selectROM();
					}
					catch(IOException ioe)
					{
						System.out.println("Caught exception");
					}
					frame.setTitle("GB\u03BC: " + Cartridge.title);
					screen.screenBlank();
					screen.loadNintendoLogo(8*7, 4*17);

					running = true;
				}
			});
		fileMenu.add(selectRomMenuItem);

		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					System.exit(0);
				}
			}
		);
		fileMenu.add(exitMenuItem);

		toolsMenu = new JMenu("Tools");
		menuBar.add(toolsMenu);

		emptyMenuItem = new JMenuItem("empty");
		toolsMenu.add(emptyMenuItem);

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

		boolean reset = false;
		while(true)
		{
			if((reset == false) && (running == true))
			{
				CPU.reset();
				reset = true;
			}
			while(running)
			{
				CPU.run();
				screen.update();
			}
			Thread.sleep(80); //give time for reset/running to update.
		}

	}
}