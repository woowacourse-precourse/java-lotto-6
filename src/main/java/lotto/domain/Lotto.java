package lotto.domain;

import static lotto.Option.ErrorMessage.NOT_LOTTO_DUPLICATION;
import static lotto.Option.ErrorMessage.NOT_SIX_LENGTH;
import static lotto.Option.ErrorMessage.ONE_TO_FORTY_FIVE;

import java.util.List;
import lotto.Option.GameOption;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_SIX_LENGTH.getErrorMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < GameOption.LOTTO_MIN_NUMBER.getNumber() || number > GameOption.LOTTO_MAX_NUMBER.getNumber()) {
                throw new IllegalArgumentException(ONE_TO_FORTY_FIVE.getErrorMessage());
            }
        });
    }

    private void validateDuplication(List<Integer> numbers) {
        if (isDuplication(numbers)) {
            throw new IllegalArgumentException(NOT_LOTTO_DUPLICATION.getErrorMessage());
        }
    }

    private boolean isDuplication(List<Integer> validator) {
        return validator.stream()
                .distinct()
                .count() != validator.size();
    }
}
