package lotto.util;

import static lotto.config.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.config.LottoConfig.MIN_LOTTO_NUMBER;

import java.util.regex.Pattern;

public class NumberUtil {

	private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

	public static boolean isNumeric(String number) {
		if (number == null) {
			return false;
		}

		return NUMBER_PATTERN.matcher(number).matches();
	}

	public static boolean isLottoNumberRange(int number) {
		return number >= MIN_LOTTO_NUMBER.getValue() && number <= MAX_LOTTO_NUMBER.getValue();
	}
}