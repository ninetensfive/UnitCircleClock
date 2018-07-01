package bg.vfu.ucclock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.util.*;
import java.text.*;

public class ClockLabel extends JLabel implements ActionListener {
	private static final long serialVersionUID = 1221678169209129599L;
	private String _type;
	private SimpleDateFormat _sdf;

	public ClockLabel(String type) {
		_type = type;

		switch (type) {
		case "time":
			setForeground(Settings.TIME_COLOR);
			_sdf = Settings.TIME_FORMAT;
			setFont(Settings.TIME_FONT);
			setHorizontalAlignment(SwingConstants.CENTER);
			break;
		case "timeInRadians":
			setForeground(Settings.TIME_IN_RADIANS_COLOR);
			setFont(Settings.TIME_IN_RADIANS_FONT);
			setHorizontalAlignment(SwingConstants.CENTER);
			break;
		default:
			_sdf = new SimpleDateFormat();
			break;
		}

		Timer t = new Timer(1000, this);
		t.start();
	}

	public void actionPerformed(ActionEvent ae) {
		if (_type.equals("timeInRadians")) {
			Calendar calendar = Calendar.getInstance();

			int hour = calendar.get(Calendar.HOUR);
			int minute = calendar.get(Calendar.MINUTE);

			if (Settings.FREEZE_CLOCK) {
				hour = Settings.FREEZE_CLOCK_AT_HOUR;
				minute = Settings.FREEZE_CLOCK_AT_MINUTE;
			}

			String hours = Units.getSmallArrow(hour);
			String minutes = Units.getBigArrow(minute);
			setText(hours + ":" + minutes);
		} else {
			Date d = new Date();
			if (Settings.FREEZE_CLOCK) {
				try {
					d = _sdf.parse(Settings.FREEZE_CLOCK_AT_HOUR + ":" + Settings.FREEZE_CLOCK_AT_MINUTE + ":0 AM");
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			setText(_sdf.format(d));
		}
	}
}
