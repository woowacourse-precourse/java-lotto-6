package lotto.validator;

import java.util.List;

public class LottoValidator {
    private static final int LOTTO_NUMBER_SIZE = 6;

    public static void validate(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        validateLottoNumbersDuplicate(numbers);
    }

    private static void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLottoNumbersDuplicate(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();

        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
