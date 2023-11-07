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
        LottoValidator.validateOutOfRange(numbers);
        LottoValidator.validateDuplication(numbers);
    }

    private void validateSizeOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int countWinningNumbers(Lotto o) {
        return (int) this.numbers.stream()
                .filter(o.numbers::contains)
                .count();
    }

    public boolean isSameAsBonusNumber(int bonus) {
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
