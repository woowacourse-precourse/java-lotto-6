package lotto.lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersLength(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(LottoConstants.INVALID_LENGTH);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        boolean duplicated = isDuplicated(numbers);

        if (duplicated) {
            throw new IllegalArgumentException(LottoConstants.DUPLICATE_NUMBER);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().toList().size() != numbers.size();
    }
}
