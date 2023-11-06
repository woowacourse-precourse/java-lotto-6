package lotto.validation;

import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoValue;

public class LottoNumberValidator {

    private LottoNumberValidator() {
    }

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoValue.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        int minNumberRange = LottoValue.MIN_LOTTO_NUMBER_RANGE.getValue();
        int maxNumberRange = LottoValue.MAX_LOTTO_NUMBER_RANGE.getValue();
        numbers.stream().forEach(number -> {
            if (number < minNumberRange || number > maxNumberRange) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage());
            }
        });
    }

    private static void validateDuplication(List<Integer> numbers) {
        int deDuplicatedCount = numbers.stream().collect(Collectors.toSet()).size();
        if (numbers.size() != deDuplicatedCount) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATION.getMessage());
        }
    }
}
