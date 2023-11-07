package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> unduplicatedNumbers = new HashSet<>(numbers);
        if (unduplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_EXCEPTION.getMessage());
        }
    }

    public int calculateMatchLottoCount(Lotto lotto) {
        return lotto.numbers.stream()
                .filter(this.numbers::contains)
                .toList()
                .size();
    }

    public int calculateMathBonusCount(BonusNumber bonusNumber) {
        if (numbers.contains(bonusNumber.getBonusNumber())) {
            return 1;
        }
        return 0;
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
