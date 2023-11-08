package lotto.module.lotto;

import lotto.global.exception.LottoException;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    public int getIncludedNumbersCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(this.numbers::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersDuplicate(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoException.LOTTO_NUMBERS_SIZE_VALIDATION.getDefaultMessage());
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        int distinctNumberCount = (int) numbers.stream()
                .distinct()
                .count();

        if (distinctNumberCount != numbers.size()) {
            throw new IllegalArgumentException(LottoException.LOTTO_NUMBERS_DUPLICATE_VALIDATION.getDefaultMessage());
        }
    }

}
