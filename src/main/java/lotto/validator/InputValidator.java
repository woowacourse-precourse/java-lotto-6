package lotto.validator;

import lotto.parser.Parser;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.constant.LottoConstant.LOTTO_LENGTH;
import static lotto.constant.LottoConstant.RANGE_START_NUMBER;
import static lotto.constant.LottoConstant.RANGE_END_NUMBER;
import static lotto.exception.InputViewExceptionMessage.FOUND_COMMA_FRONT_LAST;
import static lotto.exception.InputViewExceptionMessage.FOUND_SPECIAL_SIGN;
import static lotto.exception.InputViewExceptionMessage.NOT_POSITIVE_NUMBER;
import static lotto.exception.InputViewExceptionMessage.NOT_NUMBER;
import static lotto.exception.InputViewExceptionMessage.NO_LINE_FOUND;
import static lotto.exception.WinnerLottoExceptionMessage.WRONG_WINNER_LOTTO_LENGTH;
import static lotto.exception.WinnerLottoExceptionMessage.WRONG_BONUS_NUMBER_RANGE;
import static lotto.exception.WinnerLottoExceptionMessage.DUPLICATED_WINNER_NUMBER;
import static lotto.util.CharacterUnits.COMMA;
import static lotto.util.PatternUnits.PATTERN_FOR_FINDING_SPECIAL_SIGN;

public class InputValidator {

	private static final Integer FRONT = 0;
	private static final Integer ZERO = 0;
	private static final Integer GAP = 1;

	private static final Pattern pattern = Pattern.compile(
		PATTERN_FOR_FINDING_SPECIAL_SIGN.getPattern());

	public static void validateInputFormat(final String input) {
		validateBlank(input);
		validateCommaAtEdge(input);
		validateSpecialSignToken(input);
	}

	public static void validateCashFormat(final String cashFormat) {
		validatePositiveNumber(cashFormat);
	}

	public static void validateWinnerNumberFormat(final String winnerNumberFormat) {
		final List<String> winnerNumberDummy = Parser.parseSeparator(winnerNumberFormat);
		validateSpecialSign(winnerNumberDummy);
		validatePositiveNumbers(winnerNumberDummy);
		validateNumbers(winnerNumberDummy);
		validateNumbersSize(winnerNumberDummy);
		validateDuplicatedNumber(winnerNumberDummy);
	}

	public static void validateBonusNumberFormat(final String bonusNumberFormat) {
		validatePositiveNumber(bonusNumberFormat);
		validateNumber(bonusNumberFormat);
		validateRangeNumber(bonusNumberFormat);
	}

	private static void validatePositiveNumbers(final List<String> numberDummy) {
		for (final String number : numberDummy) {
			validatePositiveNumber(number);
		}
	}

	private static void validatePositiveNumber(final String input) {
		final Integer number = Parser.parseNumber(input);
		if (ZERO > number) {
			throw new IllegalArgumentException(NOT_POSITIVE_NUMBER.getMessage());
		}
	}

	private static void validateNumber(final String input) {
		for (final char token : input.toCharArray()) {
			if (isNotNumberToken(token)) {
				throw new IllegalArgumentException(NOT_NUMBER.getMessage());
			}
		}
	}

	private static void validateNumbersSize(final List<String> numbers) {
		if (numbers.size() != LOTTO_LENGTH.getSetting()) {
			throw new IllegalArgumentException(WRONG_WINNER_LOTTO_LENGTH.getMessage());
		}
	}

	private static void validateRangeNumber(final String number) {
		final Integer parsedNumber = Parser.parseNumber(number);
		if (!(RANGE_START_NUMBER.getSetting() <= parsedNumber
			&& parsedNumber <= RANGE_END_NUMBER.getSetting())) {
			throw new IllegalArgumentException(WRONG_BONUS_NUMBER_RANGE.getMessage());
		}
	}

	private static void validateDuplicatedNumber(final List<String> numberDummy) {
		if (numberDummy.stream()
			.map(Parser::parseNumber)
			.collect(Collectors.toSet())
			.size() != LOTTO_LENGTH.getSetting()) {
			throw new IllegalArgumentException(DUPLICATED_WINNER_NUMBER.getMessage());
		}
	}

	private static Boolean isNotNumberToken(final Character token) {
		return !(Character.isDigit(token));
	}

	private static void validateBlank(final String input) {
		if (input.isBlank() || input == null) {
			throw new IllegalStateException(NO_LINE_FOUND.getMessage());
		}

	}

	private static void validateNumbers(final List<String> numbers) {
		for (final String number : numbers) {
			validateRangeNumber(number);
			validateNumber(number);
		}
	}

	private static void validateSpecialSign(final List<String> numbers) {
		for (final String number : numbers) {
			validateSpecialSignToken(number);
		}
	}

	private static void validateSpecialSignToken(final String number) {
		if (pattern.matcher(number)
			.find()) {
			throw new IllegalArgumentException(FOUND_SPECIAL_SIGN.getMessage());
		}

	}

	public static void validateCommaAtEdge(final String input) {
		if (input.charAt(FRONT) == COMMA.getUnit().charAt(FRONT)
			|| input.charAt(input.length() - GAP) == COMMA.getUnit().charAt(FRONT)) {
			throw new IllegalArgumentException(FOUND_COMMA_FRONT_LAST.getMessage());
		}
	}

}
