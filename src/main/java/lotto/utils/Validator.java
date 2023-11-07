package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    public static void validateNumbers(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateLottoNumberRange(number);
        }
    }

    public static void validateNonNumericNumbers(List<String> input) {
        for (String number : input) {
            validateNonNumeric(number);
        }
    }

    public static void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력하세요.");
        }
    }

    public static void validateUnit(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 숫자여야 합니다.");
        }
    }

    public static void validateAmountRange(int input) {
        if (input < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000 이상의 숫자를 입력해주세요.");
        }
    }

    public static void validateLottoNumberRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
