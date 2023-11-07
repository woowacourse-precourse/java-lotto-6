package lotto.domain.model;

import lotto.domain.constant.Constraint;
import lotto.domain.constant.DomainException;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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

    public boolean contains(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public Result countMatch(Lotto target, BonusNumber bonus) {
        int count = 0;
        boolean isBonusMatched = false;
        for (Integer number : numbers) {
            if (target.contains(number)) count++;
            if (number.equals(bonus.bonus())) isBonusMatched = true;
        }
        return Result.of(count, isBonusMatched);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
