package lotto.Util;

import static lotto.Util.LottoOption.*;
import static lotto.Util.ValidatorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public static boolean isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NULL_OR_EMPTY_ERROR);
        }
        return true;
    }

    public static void checkDivisibleBy1000(String input) {
        if (Integer.parseInt(input) % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + CAN_NOT_DIVIDE_BY_1000_ERROR);
        }
    }

    public static boolean isNumber(String input) {
        if (input.contains(LOTTO_NUMBER_DELIMITER)) {
            input = input.replace(LOTTO_NUMBER_DELIMITER, "");
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_NUMBER_ERROR);
            }
        }
        return true;
    }

    public static void checkSixNumber(String input) {
        String[] parts = input.split(LOTTO_NUMBER_DELIMITER);
        if (parts.length != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_SIX_DIGIT_ERROR);
        }
    }

    public static boolean isValidRangeNumber(String input) {
        if (!input.contains(LOTTO_NUMBER_DELIMITER)) {
            if (Integer.parseInt(input) < LOTTO_MIN_NUMBER || Integer.parseInt(input) > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_VALID_RANGE_NUMBER_ERROR);
            }
        }
        List<String> numbers = List.of(input.split(LOTTO_NUMBER_DELIMITER));
        for (String number : numbers) {
            if (Integer.parseInt(number) < LOTTO_MIN_NUMBER || Integer.parseInt(number) > LOTTO_MAX_NUMBER) {
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
        List<String> numbers = List.of(input.split(LOTTO_NUMBER_DELIMITER));
        Set<String> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_DISTINCT_NUMBER_ERROR);
            }
        }
    }

    public static void checkDistinctBetweenWinningAndBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        Set<Integer> numbers = new HashSet<>(winningNumbers);
        if (!numbers.add(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_DISTINCT_NUMBER_ERROR);
        }
    }
}
