package lotto.utils;

import static java.util.regex.Pattern.compile;
import static lotto.constants.ExceptionMessage.EMPTY_INPUT_EXCEPTION;
import static lotto.constants.ExceptionMessage.INTEGER_OUT_BOUNDARY;
import static lotto.constants.ExceptionMessage.LOTTO_DUPPLICATE_NUMBER;
import static lotto.constants.ExceptionMessage.NULL_INPUT_EXCEPTION;
import static lotto.constants.ExceptionMessage.NUMBER_NOT_INTGER;
import static lotto.constants.ExceptionMessage.NUMBER_OUT_BOUNDARY;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.constants.InputConstants;
import lotto.constants.LottoConstants;

public class InputValidator {

    private static final String NUMBER_MATCH_REGEX = "^[0-9]*$";
    private static final int MIN_MONEY = 0;
    private static final int MAX_MONEY = 100000000;
    private static final Pattern NUMBER = compile(NUMBER_MATCH_REGEX);


    public static String validate(final String input) {
        if (IsNull(input)) {
            throw new NullPointerException(NULL_INPUT_EXCEPTION);
        }
        if (IsEmptyString(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION);
        }
        if (isBlankString(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION);
        }
        return input;
    }

    private static boolean IsEmptyString(final String input) {
        return input.isEmpty();
    }

    private static boolean IsNull(final String input) {
        return input == null;
    }

    private static boolean isBlankString(final String input) {
        return input.isBlank();
    }

    public static String validateMoney(final String input) {
        String money = input.replace(",", "");
        return validateInt(money);
    }

    public static String validateWinnings(final String winnings) {
        List<String> input = Arrays.asList(winnings.split(InputConstants.WINNING_DELIMITER.getConstants()));
        List<String> duplicated = input.stream().map(InputValidator::validateLottoNumber).distinct().toList();
        if (input.size() != duplicated.size()) {
            throw new IllegalArgumentException(LOTTO_DUPPLICATE_NUMBER);
        }
        return winnings;
    }

    public static String validateLottoNumber(final String input) {
        String number = validateInt(input);
        return number;
    }

    private static boolean IsRange(final String input) {
        int number = Integer.parseInt(input);
        return LottoConstants.MIN_NUMBER.getConstants() <= number
                && number <= LottoConstants.MAX_NUMBER.getConstants();
    }

    public static String validateInt(final String input) {
        if (!IsInPattern(input, NUMBER)) {
            throw new NumberFormatException(String.format(NUMBER_NOT_INTGER,
                    InputConstants.WINNING_DELIMITER.getConstants()));
        }
        if (!IsBoundary(input)) {
            throw new IllegalArgumentException(NUMBER_OUT_BOUNDARY);
        }
        return input;
    }

    private static boolean IsInPattern(final String input, final Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private static boolean IsBoundary(final String input) {
        try {
            int isInt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_OUT_BOUNDARY);
        }
        return MIN_MONEY < Integer.parseInt(input) && Integer.parseInt(input) < MAX_MONEY;
    }

}
