package lotto.domain;

import lotto.validator.NumbersDuplicationValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        Collections.sort(copiedNumbers);
        return copiedNumbers;
    }

    public int getMatchedNumbersCount(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::isMatchedWithWinningNumbers)
                .count();
    }

    public boolean hasBonusNumber(BonusNumber bonusNumber) {
        return numbers.stream()
                .anyMatch(bonusNumber::isMatchedWithBonusNumber);
    }

    private void validateDuplication(List<Integer> numbers) {
        NumbersDuplicationValidator numbersDuplicationValidator = new NumbersDuplicationValidator();
        numbersDuplicationValidator.validate(numbers);
    }
}
