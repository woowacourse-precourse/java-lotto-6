package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.validation.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    public int getMatchCount(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(number -> winningNumber.isContains(number))
                .count();
    }

    public boolean isMatchBonus(BonusNumber bonusNumber) {
        return numbers.stream()
                .anyMatch(number -> bonusNumber.isEqual(number));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
