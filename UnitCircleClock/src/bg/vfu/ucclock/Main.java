package bg.vfu.ucclock;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Main {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(Settings.APP_NAME);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource(Settings.APP_ICON)));

		frame.setBounds(Settings.BOUNDS_X, Settings.BOUNDS_Y, Settings.BOUNDS_WIDTH + 15, Settings.BOUNDS_HEIGHT + 30);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLayeredPane lp = frame.getLayeredPane();

		UnitCirclePanel unitCirclePanel = new UnitCirclePanel();
		unitCirclePanel.setBounds(0, 0, Settings.BOUNDS_WIDTH, Settings.BOUNDS_HEIGHT);
		unitCirclePanel.setOpaque(false);

		AnalogClockPanel analogClockPanel = new AnalogClockPanel();
		analogClockPanel.setBounds(0, 0, Settings.BOUNDS_WIDTH + 10, Settings.BOUNDS_HEIGHT);
		analogClockPanel.setOpaque(false);

		ClockLabel clockLabelInRadians = new ClockLabel("timeInRadians");
		clockLabelInRadians.setBounds(0, 20, Settings.BOUNDS_WIDTH, Settings.BOUNDS_HEIGHT);
		clockLabelInRadians.setOpaque(false);

		ClockLabel clockLabel = new ClockLabel("time");
		clockLabel.setBounds(0, -20, Settings.BOUNDS_WIDTH, Settings.BOUNDS_HEIGHT);
		clockLabel.setOpaque(false);

		lp.add(unitCirclePanel, new Integer(1));
		lp.add(analogClockPanel, new Integer(2));
		lp.add(clockLabelInRadians, new Integer(3));
		lp.add(clockLabel, new Integer(4));
	}
}
