package bg.vfu.ucclock;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;

public class Settings {
	public static final String APP_NAME = "Unit Circle Clock";
	public static final String APP_ICON = "/images/clock_icon.png";

	public static int BOUNDS_X = 100;
	public static int BOUNDS_Y = 100;
	public static int BOUNDS_WIDTH = 535;
	public static int BOUNDS_HEIGHT = 483;

	public static final String UNIT_CIRCLE_IMAGE = "/images/unit_circle.png";

	public static final Color SMALL_ARROW_COLOR = Color.RED;
	public static final double SMALL_ARROW_RADIUS = 130;
	public static final float SMALL_ARROW_TICKNESS = 4;

	public static final Color BIG_ARROW_COLOR = Color.RED;
	public static final double BIG_ARROW_RADIUS = 210;
	public static final float BIG_ARROW_TICKNESS = 3;

	public static final Color TIME_COLOR = Color.BLUE;
	public static final Font TIME_FONT = new Font("sans-serif", Font.PLAIN, 40);
	public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm:ss a");

	public static final Color TIME_IN_RADIANS_COLOR = Color.BLUE;
	public static final Font TIME_IN_RADIANS_FONT = new Font("sans-serif", Font.PLAIN, 40);

	public static boolean FREEZE_CLOCK = false;
	public static int FREEZE_CLOCK_AT_HOUR = 9;
	public static int FREEZE_CLOCK_AT_MINUTE = 55;
}
