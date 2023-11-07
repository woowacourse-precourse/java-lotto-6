package lotto.domain;

import lotto.utils.LottoValidator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortAscendingOrder(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSizeOfNumbers(numbers);
        validateDuplication(numbers);
        LottoValidator.validateOutOfRange(numbers);
    }

    private void validateSizeOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplication(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    public int countWinningNumbers(Lotto o) {
        return (int) this.numbers.stream()
                .filter(o.numbers::contains)
                .count();
    }

    public boolean hasBonusNumber(int bonus) {
        return numbers.contains(bonus);
    }

    private List<Integer> sortAscendingOrder(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
