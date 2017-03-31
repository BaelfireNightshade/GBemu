import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import javax.swing.BorderFactory;

import java.awt.Dimension;
import javax.swing.Box;

import java.util.Timer;
import java.util.TimerTask;

public class DebugPanel extends JPanel
{
	private JLabel labelAF;
	private JLabel labelBC;
	private JLabel labelDE;
	private JLabel labelHL;
	private JLabel labelSP;
	private JLabel labelPC;

	private JButton pause;
	private JButton unpause;
	private JButton step;

	private Timer updateTimer;

	class DebugTimer extends TimerTask
	{
		private DebugPanel dbPanel;

		public DebugTimer(DebugPanel newDBPanel)
		{
			dbPanel = newDBPanel;
		}

		public void run()
		{
			dbPanel.update();
		}
	}

	public DebugPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(new RegisterPanel());
		add(Box.createRigidArea(new Dimension(20, 0)));
		add(new ControlPanel());

		updateTimer = new Timer();
		updateTimer.schedule(new DebugTimer(this), 0, 1);
	}

	public void update()
	{
		labelAF.setText(String.format(" AF: 0x%04X ", Register.readAF()));
		labelBC.setText(String.format(" BC: 0x%04X ", Register.readBC()));
		labelDE.setText(String.format(" DE: 0x%04X ", Register.readDE()));
		labelHL.setText(String.format(" HL: 0x%04X ", Register.readHL()));
		labelSP.setText(String.format(" SP: 0x%04X ", Register.readSP()));
		labelPC.setText(String.format(" PC: 0x%04X ", Register.readPC()));
	}

	private class RegisterPanel extends JPanel
	{
		public RegisterPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			labelAF = new JLabel(String.format("AF: 0x%04X", Register.readAF()));
			add(labelAF);

			labelBC = new JLabel(String.format("BC: 0x%04X", Register.readBC()));
			add(labelBC);

			labelDE = new JLabel(String.format("DE: 0x%04X", Register.readDE()));
			add(labelDE);

			labelHL = new JLabel(String.format("HL: 0x%04X", Register.readHL()));
			add(labelHL);

			add(Box.createRigidArea(new Dimension(0, 10)));

			labelPC = new JLabel(String.format("PC: 0x%04X", Register.readPC()));
			add(labelPC);

			labelSP = new JLabel(String.format("SP: 0x%04X", Register.readSP()));
			add(labelSP);

			setBorder(BorderFactory.createRaisedBevelBorder());
		}
	}

	private class ControlPanel extends JPanel
	{
		public ControlPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			pause = new JButton("Pause");
			pause.addActionListener(Listeners.run_pause);
			add(pause);

			unpause = new JButton("Unpause");
			unpause.addActionListener(Listeners.run_run);
			add(unpause);

			add(Box.createRigidArea(new Dimension(0, 10)));

			step = new JButton("Step");
			step.addActionListener(Listeners.tools_debug_step);
			add(step);

			setBorder(BorderFactory.createEtchedBorder());
		}
	}
}