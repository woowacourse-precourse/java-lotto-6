package lotto.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String NULL_OR_EMPTY_ERROR = "입력값이 NULL 또는 EMPTY값입니다.";
    public static final String CAN_NOT_DIVIDE_BY_1000_ERROR = "로또 구입 금액은 1000으로 나누어 떨어져야 합니다.";
    public static final String NOT_A_NUMBER_ERROR = "숫자로 입력하셔야합니다.";
    public static final String NOT_A_SIX_NUMBER_ERROR = "당첨 번호 6자리를 입력해주셔야 합니다.";
    public static final String NOT_A_VALID_RANGE_NUMBER_ERROR = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String NOT_A_VALID_DELIMITER_ERROR = "구분자는 콤마(,)로 이루어져야 합니다.";
    public static final String NOT_A_DISTINCT_NUMBER_ERROR = "로또 번호의 각 자리수는 서로 달라야합니다.";


    public static boolean isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NULL_OR_EMPTY_ERROR);
        }
        return true;
    }

    public static void checkDivisibleBy1000(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + CAN_NOT_DIVIDE_BY_1000_ERROR);
        }
    }

    public static boolean isNumber(String input) {
        if (input.contains(",")) {
            input = input.replace(",", "");
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_NUMBER_ERROR);
            }
        }
        return true;
    }

    public static void checkSixNumber(String input) {
        String[] parts = input.split(",");
        if (parts.length != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_SIX_NUMBER_ERROR);
        }
    }

    public static boolean isValidRangeNumber(String input) {
        if (!input.contains(",")) {
            if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45) {
                throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_VALID_RANGE_NUMBER_ERROR);
            }
        }
        List<String> numbers = List.of(input.split(","));
        for (String number : numbers) {
            if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
                throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_VALID_RANGE_NUMBER_ERROR);
            }
        }
        return true;
    }

    public static void checkCommaDelimiter(String input) {
        Pattern pattern = Pattern.compile("^[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+$");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_VALID_DELIMITER_ERROR);
        }
    }

    public static void checkDistinctNumbers(String input) {
        List<String> numbers = List.of(input.split(","));
        Set<String> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_DISTINCT_NUMBER_ERROR);
            }
        }
    }

    public static void checkDistinctBetweenWinningAndBonusNumber(String winningNumbers, String bonusNumber) {
        Set<String> numbers = new HashSet<>(Arrays.asList(winningNumbers.split(",")));
        if (!numbers.add(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_DISTINCT_NUMBER_ERROR);
        }
    }
}
