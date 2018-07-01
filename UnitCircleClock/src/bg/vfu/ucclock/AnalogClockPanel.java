package bg.vfu.ucclock;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnalogClockPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 6311948643850456174L;

	private HashMap<Integer, Integer> _smallArrowDegrees = Units.mapUnitsToDegrees(12);
	private HashMap<Integer, Integer> _bigArrowDegrees = Units.mapUnitsToDegrees(60);

	public AnalogClockPanel() {
		Timer t = new Timer(1000, this);
		t.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int width = getWidth() / 2;
		int height = getHeight() / 2;

		Graphics2D g2 = (Graphics2D) g;

		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);

		if (Settings.FREEZE_CLOCK) {
			hour = Settings.FREEZE_CLOCK_AT_HOUR;
			minute = Settings.FREEZE_CLOCK_AT_MINUTE;
		}

		drawSmallArrow(hour, width, height, g2);
		drawBigArrow(minute, width, height, g2);
	}

	private void drawSmallArrow(int hour, int x1, int y1, Graphics2D g2) {
		double angleInRadians = Math.toRadians(_smallArrowDegrees.get(hour));

		double x2 = x1 + (Settings.SMALL_ARROW_RADIUS * Math.cos(angleInRadians));
		double y2 = y1 + (Settings.SMALL_ARROW_RADIUS * Math.sin(angleInRadians));

		g2.setColor(Settings.SMALL_ARROW_COLOR);
		g2.setStroke(new BasicStroke(Settings.SMALL_ARROW_TICKNESS));
		g2.draw(new Line2D.Double(x1, y1, x2, y2));

	}

	private void drawBigArrow(int minute, int x1, int y1, Graphics2D g2) {
		double angleInRadians = Math.toRadians(_bigArrowDegrees.get(minute));

		double x2 = x1 + (Settings.BIG_ARROW_RADIUS * Math.cos(angleInRadians));
		double y2 = y1 + (Settings.BIG_ARROW_RADIUS * Math.sin(angleInRadians));

		g2.setColor(Settings.BIG_ARROW_COLOR);
		g2.setStroke(new BasicStroke(Settings.BIG_ARROW_TICKNESS));
		g2.draw(new Line2D.Double(x1, y1, x2, y2));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// this.setBounds(5, 0, Settings.BOUNDS_WIDTH, Settings.BOUNDS_HEIGHT);
		// this.setOpaque(false);
		//
		// JLayeredPane lp = _frame.getLayeredPane();
		// lp.add(analogClockPanel, new Integer(2));
		this.paintComponent(getGraphics());

	}
}
