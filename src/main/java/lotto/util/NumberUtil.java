package lotto.util;

import static lotto.config.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.config.LottoConfig.MIN_LOTTO_NUMBER;

import java.util.regex.Pattern;

public class NumberUtil {

	private static final Pattern BONUS_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
	private static final Pattern WINNING_NUMBERs_PATTERN = Pattern.compile("^[0-9,]*$");

	public static boolean isNumericBonusNumber(String number) {
		if (number == null) {
			return false;
		}

		return BONUS_NUMBER_PATTERN.matcher(number).matches();
	}

	public static boolean isNumericWinningNumbers(String numbers) {
		if (numbers == null) {
			return false;
		}

		return WINNING_NUMBERs_PATTERN.matcher(numbers).matches();
	}

	public static boolean isLottoNumberRange(int number) {
		return number >= MIN_LOTTO_NUMBER.getValue() && number <= MAX_LOTTO_NUMBER.getValue();
	}
}