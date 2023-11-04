package lotto.util;

import java.util.regex.Pattern;

public class NumberUtil {

	public static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}

		return NUMBER_PATTERN.matcher(strNum).matches();
	}
}