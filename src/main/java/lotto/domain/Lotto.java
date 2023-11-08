package lotto.domain;

import static lotto.option.Error.NOT_LOTTO_DUPLICATION;
import static lotto.option.Error.NOT_SIX_LENGTH;
import static lotto.option.Error.ONE_TO_FORTY_FIVE;
import static lotto.option.GameOption.LOTTO_NUMBER_LENGTH;

import java.util.List;
import lotto.option.GameOption;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH.getNumber()) {
            throw new IllegalArgumentException(NOT_SIX_LENGTH.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < GameOption.LOTTO_MIN_NUMBER.getNumber() || number > GameOption.LOTTO_MAX_NUMBER.getNumber()) {
                throw new IllegalArgumentException(ONE_TO_FORTY_FIVE.getMessage());
            }
        });
    }

    private void validateDuplication(List<Integer> numbers) {
        if (isDuplication(numbers)) {
            throw new IllegalArgumentException(NOT_LOTTO_DUPLICATION.getMessage());
        }
    }

    private boolean isDuplication(List<Integer> validator) {
        return validator.stream()
                .distinct()
                .count() != validator.size();
    }
}
