package lotto.util;

import java.text.DecimalFormat;
import java.util.List;

public class Format {
	public static float calculateYield(float profit, int purchaseAmount) {
		return profit / purchaseAmount * 100 - 100;
	}

	public static String floatFormat(float target, int precision) {
		DecimalFormat formatter = new DecimalFormat("###,##0.0");
		String rounded = String.format("%." + precision + "f", target);
		return formatter.format(Float.parseFloat(rounded));
	}

	public static String integerListToString(List<Integer> target) {
		String result = target.toString();
		result = result.substring(1, result.length() - 1);
		result = result.replaceAll(" ", "");
		return result;
	}
}
