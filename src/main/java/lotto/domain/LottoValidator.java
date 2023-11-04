package lotto.domain;

import lotto.constraints.ErrorMessage;

import java.util.List;

public class LottoValidator {

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != NumberConstraints.LOTTO_PER_NUMBER.value()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NumberConstraints.LOTTO_PER_NUMBER.value()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(LottoValidator::validateNumberRange);
    }

    public static void validateNumberRange(int numbers) {
        if (numbers < NumberConstraints.LOTTO_MIN_NUMBER.value() || numbers > NumberConstraints.LOTTO_MAX_NUMBER.value()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }
}

