package lotto.util;

import java.util.List;
import java.util.regex.Pattern;
import lotto.domain.Lotto;

public class Validator {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_RANGE_NUM = 1;
    private static final int MAX_RANGE_NUM = 45;
    private static final String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 1 이상의 숫자로만 이루어진 값을 입력해주세요.";
    private static final String WRONG_UNIT_ERROR_MESSAGE = "[ERROR] 입력 금액은 1,000원 단위여야 합니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1~45 사이의 숫자를 입력해주세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 숫자가 포함되어 있습니다.";

    public static void validateNonNumeric(String input) {
        String pattern = "^[1-9][0-9]*$";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static void validateUnit(String input) {
        int num = Integer.parseInt(input);
        if (num % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(WRONG_UNIT_ERROR_MESSAGE);
        }
    }

    public static void validateRange(int input) {
        if (input < MIN_RANGE_NUM || input > MAX_RANGE_NUM) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateNonNumericNumbers(List<String> input) {
        for (String num : input) {
            validateNonNumeric(num);
        }
    }

    public static void validateRangeOfNumbers(List<Integer> numbers) {
        for (int num : numbers) {
            validateRange(num);
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateDuplicateLotto(int number, Lotto lotto) {
        if (lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
