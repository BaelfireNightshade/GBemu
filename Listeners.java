import java.awt.event.*;
import javax.swing.JFrame;
import java.io.IOException;
public class Listeners
{
	public static ActionListener file_selectRom = new File_selectRom();
	public static ActionListener file_exit = new File_exit();
	public static ActionListener run_run = new Run_run();
	public static ActionListener run_pause = new Run_pause();
	public static ActionListener run_reset = new Run_reset();
	public static ActionListener tools_debug = new Tools_debug();
	public static ActionListener tools_debug_step = new Tools_debug_step();
	public static KeyListener keypad = new Keypad();
}

class File_selectRom implements ActionListener
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
		GameboyEmu.frame.setTitle("GB\u03BC: " + Cartridge.title);
		GameboyEmu.screen.screenBlank();
		GameboyEmu.screen.loadNintendoLogo(8*7, 4*17);

		GameboyEmu.running = true;
	}
}

class File_exit implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent event)
	{
		System.exit(0);
	}
}

class Run_run implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent event)
	{
		GameboyEmu.cpu.unpause();
	}
}

class Run_pause implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent event)
	{
		GameboyEmu.cpu.pause();
	}
}

class Run_reset implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent event)
	{
		GameboyEmu.cpu.reset();
	}
}

class Tools_debug implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent event)
	{
		JFrame debugFrame= new JFrame("Debugger");
		debugFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		debugFrame.getContentPane().add(new DebugPanel());
		debugFrame.pack();
		debugFrame.setVisible(true);
	}
}

class Tools_debug_step implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent event)
	{
		GameboyEmu.cpu.step();
	}
}

class Keypad implements KeyListener
{
	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT: //left
			IO.KP_Left = 0;
			break;
			case KeyEvent.VK_UP: //up
			IO.KP_Up = 0;
			break;
			case KeyEvent.VK_RIGHT: //right
			IO.KP_Right = 0;
			break;
			case KeyEvent.VK_DOWN: //down
			IO.KP_Down = 0;
			break;
			case KeyEvent.VK_A: //K: a, GB: b
			IO.KP_B = 0;
			break;
			case KeyEvent.VK_S: //K: s, GB: a
			IO.KP_A = 0;
			break;
			case KeyEvent.VK_X: //K: x, GB: start
			IO.KP_Start = 0;
			break;
			case KeyEvent.VK_Z: //K: z, GB: select
			IO.KP_Select = 0;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT: //left
			IO.KP_Left = 1;
			break;
			case KeyEvent.VK_UP: //up
			IO.KP_Up = 1;
			break;
			case KeyEvent.VK_RIGHT: //right
			IO.KP_Right = 1;
			break;
			case KeyEvent.VK_DOWN: //down
			IO.KP_Down = 1;
			break;
			case KeyEvent.VK_A: //K: a, GB: b
			IO.KP_B = 1;
			break;
			case KeyEvent.VK_S: //K: s, GB: a
			IO.KP_A = 1;
			break;
			case KeyEvent.VK_X: //K: x, GB: start
			IO.KP_Start = 1;
			break;
			case KeyEvent.VK_Z: //K: z, GB: select
			IO.KP_Select = 1;
			break;
		}
	}
}