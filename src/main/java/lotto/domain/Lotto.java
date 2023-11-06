package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constraint.SIZE.getValue()) {
            throw new IllegalArgumentException(DomainException.LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (set.contains(number))
                throw new IllegalArgumentException(DomainException.LOTTO_DUPLICATION.getMessage());
            set.add(number);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if ((number < Constraint.MIN.getValue()) || (number > Constraint.MAX.getValue()))
                throw new IllegalArgumentException(DomainException.LOTTO_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    boolean contains(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    Result countMatch(Lotto target, BonusNumber bonus) {
        int count = 0;
        boolean isBonusMatched = false;
        for (Integer number : numbers) {
            if (target.contains(number)) count++;
            if (number.equals(bonus.bonus())) {
                count++;
                isBonusMatched = true;
            }
        }
        return Result.of(count, isBonusMatched);
    }
}
