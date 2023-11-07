package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TokenizedInputValidator {
    private final static int LOTTO_SIZE = 6;
    private final static int START_RANGE = 1;
    private final static int END_RANGE = 45;
    private final static String DIGIT_REGEX = "^[0-9]+$";
    private final static String NOT_CORRECT_SIZE_MSG = "[ERROR] 당첨 숫자의 개수는 6개여야 합니다.";
    private final static String DUPLICATE_MSG = "[ERROR] 중복 숫자를 입력할 수 없습니다.";
    private final static String WRONG_FORMAT_MSG = "[ERROR] 1 ~ 45 사이의 숫자와 쉼표만 입력 가능합니다.";

    public static void check(String[] input) {
        String[] trimmedInputs = Arrays.stream(input)
                .map(String::trim)
                .toArray(String[]::new);

        checkFormat(trimmedInputs);
        checkSize(trimmedInputs);
        checkUnique(trimmedInputs);
    }

    private static void checkSize(String[] splitNumbers) {
        if (splitNumbers.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(NOT_CORRECT_SIZE_MSG);
        }
    }

    private static void checkUnique(String[] splitNumbers) {
        if (getUniqueNumberCount(splitNumbers) != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_MSG);
        }
    }

    private static void checkFormat(String[] splitNumbers) {
        for (String numberStr : splitNumbers) {
            if (!isDigit(numberStr) || isOutOfRange(Integer.parseInt(numberStr))) {
                throw new IllegalArgumentException(WRONG_FORMAT_MSG);
            }
        }
    }

    private static boolean isOutOfRange(int number) {
        return (number < START_RANGE || number > END_RANGE);
    }

    private static long getUniqueNumberCount(String[] splitNumbers) {
        Set<String> uniqueNumbers = new HashSet<>(Arrays.asList(splitNumbers));
        return uniqueNumbers.size();
    }

    private static boolean isDigit(String number) {
        return number.matches(DIGIT_REGEX);
    }
}
