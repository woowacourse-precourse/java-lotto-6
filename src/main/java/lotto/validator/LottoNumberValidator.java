package lotto.validator;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.GameNumberConstants.*;

public class LottoNumberValidator {

    public static void validateNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplication(numbers);
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_NUMBERS_TO_MATCH.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        List<Integer> deduplicatedNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (deduplicatedNumbers.size() == numbers.size()) {
            return;
        }
        throw new IllegalArgumentException();
    }

}
