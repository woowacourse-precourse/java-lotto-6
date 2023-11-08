package lotto.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static lotto.exception.ErrorMessage.*;
import static lotto.exception.ExceptionHandler.*;
import static lotto.util.InputValidator.*;

public class Converter {
    private static final String SPLIT_REGEX = ",";
    private static final DecimalFormat decimalFormat = new DecimalFormat("#,###");
    private static final DecimalFormat decimalFormatWithPoint = new DecimalFormat("#,###.0");

    public static List<Integer> convertStringToIntegers(String input) throws IllegalArgumentException {
        String[] splitNums = splitInputIntoRegex(removeSpace(input));
        List<Integer> convertedNumbers = new ArrayList<>();

        if (!isValidSplitSize(splitNums)) {
            triggerArgException(INVALID_LOTTO_NUMBER_LENGTH);
        }

        for (String num : splitNums) {
            convertedNumbers.add(convertValidLottoNumber(num));
        }
        if (isDuplicate(convertedNumbers)) {
            triggerArgException(DUPLICATE_LOTTO_NUMBER);
        }
        return convertedNumbers;
    }

    public static int convertValidUserBuyAmount(String amount) throws IllegalArgumentException {
        int parsed;
        if (!isNumber(amount)) {
            triggerArgException(NOT_A_NUMBER_TO_CONVERT);
        }
        parsed = Integer.parseInt(amount);

        if (!isPositive(parsed)) {
            triggerArgException(NOT_POSITIVE_NUMBER);
        }

        if (!isDividedInto1000(parsed)) {
            triggerArgException(NOT_BUY_AMOUNT_1000_WON_UNIT);
        }
        return parsed;
    }

    public static int convertValidLottoNumber(String input) throws IllegalArgumentException {
        int parsed;
        if (!isNumber(input)) {
            triggerArgException(NOT_A_NUMBER_TO_CONVERT);
        }
        parsed = Integer.parseInt(input);

        if (!isInRange(parsed)) {
            triggerArgException(NO_WITHIN_SCOPE_LOTTO_NUMBER);
        }
        return parsed;
    }

    private static String[] splitInputIntoRegex(String input) {
        return input.split(SPLIT_REGEX);
    }

    public static String convertNumberFormatString(long number) {
        return decimalFormat.format(number);
    }

    public static String convertNumberFormatString(double number) {
        return decimalFormatWithPoint.format(number);
    }

    public static String removeSpace(String input) {
        return input.replace(" ", "");
    }
}
