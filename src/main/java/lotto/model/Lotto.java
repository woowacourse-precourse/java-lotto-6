package lotto.model;

import java.util.List;
import lotto.message.LottoExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoExceptionMessage.INVALID_LOTTO_LENGTH.getMessage());
        }
    }

    private void duplicateValidate(List<Integer> numbers) {
        long uniqueCount = numbers.stream().distinct().count();
        if (numbers.size() != uniqueCount) {
            throw new IllegalArgumentException(LottoExceptionMessage.INVALID_LOTTO_DUPLICATED.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
