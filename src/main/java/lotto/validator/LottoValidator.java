package lotto.validator;

import java.util.List;
import lotto.model.LottoNumber;

public class LottoValidator {

    public static void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicatedNumber(numbers);
        validateNumbersRange(numbers);
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private static void validateNumberRange(Integer number) {
        if (number < LottoNumber.MIN.getNumber() || number > LottoNumber.MAX.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (LottoNumber.isInRange(numbers.size())) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoNumber.COUNT.getNumber()) {
            throw new IllegalArgumentException();
        }
    }
}
