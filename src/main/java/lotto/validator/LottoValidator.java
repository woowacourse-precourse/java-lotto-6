package lotto.validator;

import java.util.List;

public class LottoValidator {
    public static void validate(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        validateLottoNumbersDuplicate(numbers);
    }

    private static void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLottoNumbersDuplicate(List<Integer> numbers) {
        List<Integer> disticedNumbers = numbers.stream()
                .distinct()
                .toList();

        if (disticedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
