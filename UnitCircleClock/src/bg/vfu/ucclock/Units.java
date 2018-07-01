package bg.vfu.ucclock;

import java.util.HashMap;

public class Units {
	private static HashMap<Integer, String> _smallArrow = createSmallArrowMap();
	private static HashMap<Integer, String> _bigArrow = createBigArrowMap();

	public static String getSmallArrow(int number) {
		return _smallArrow.get(number);
	}

	public static String getBigArrow(int number) {
		return _bigArrow.get(number);
	}

	private static HashMap<Integer, String> createSmallArrowMap() {
		HashMap<Integer, String> smallArrow = new HashMap<Integer, String>();

		double currentDegrees = 90;
		for (int i = 0; i < 12; i++) {
			String fractionResult = convertDecimalToFraction(currentDegrees / 180.0, "π");
			smallArrow.put(i, fractionResult);

			currentDegrees -= 30;

			if (currentDegrees == 0) {
				currentDegrees = 360;
			}
		}

		return smallArrow;
	}

	private static HashMap<Integer, String> createBigArrowMap() {
		HashMap<Integer, String> bigArrow = new HashMap<Integer, String>();

		double currentDegrees = 90.0;
		for (int i = 0; i < 60; i++) {
			String fractionResult = convertDecimalToFraction(currentDegrees / 180.0, "π");
			bigArrow.put(i, fractionResult);

			currentDegrees -= 6;

			if (currentDegrees == 0) {
				currentDegrees = 360;
			}
		}

		return bigArrow;
	}

	static HashMap<Integer, Integer> mapUnitsToDegrees(int units) {
		HashMap<Integer, Integer> toDegrees = new HashMap<Integer, Integer>();
		int parts = 360 / units;
		int startFrom = (units / 4) + 1;
		int currentDegrees = parts;
		int position = 0;

		for (int i = 0; i < units; i++) {
			position = (i + startFrom) % units;

			toDegrees.put(position, currentDegrees);
			currentDegrees += parts;
		}

		return toDegrees;
	}

	static private String convertDecimalToFraction(double x, String add) {
		if (x < 0) {
			return "-" + convertDecimalToFraction(-x, add);
		}
		double tolerance = 1.0E-6;
		double h1 = 1;
		double h2 = 0;
		double k1 = 0;
		double k2 = 1;
		double b = x;
		do {
			double a = Math.floor(b);
			double aux = h1;
			h1 = a * h1 + h2;
			h2 = aux;
			aux = k1;
			k1 = a * k1 + k2;
			k2 = aux;
			b = 1 / (b - a);
		} while (Math.abs(x - h1 / k1) > x * tolerance);

		return (int) h1 + add + "/" + (int) k1;
	}
}
