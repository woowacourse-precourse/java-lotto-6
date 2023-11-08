package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.exception.CustomException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new CustomException(ErrorMessage.LOTTO_MUST_HAVE_SIX);
        }
        if (validateIsDuplicated(numbers)) {
            throw new CustomException(ErrorMessage.LOTTO_MUST_HAVE_NOT_DUPLICATED_NUMBER);
        }
    }

    private boolean validateIsDuplicated(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        return distinctCount != numbers.size();
    }

}
