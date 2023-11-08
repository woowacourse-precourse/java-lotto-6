package lotto.validator;

import java.util.List;

public class LottoValidator {
    public static void isInvalidSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDuplicated(List<Integer> numbers) {
        if(numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isInvalidNumber(List<Integer> numbers) {
        if(numbers.stream().anyMatch(number -> number > 45 || number < 1)) {
            throw new IllegalArgumentException();
        }
    }
}
