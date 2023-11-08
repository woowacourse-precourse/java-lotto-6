package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numbersWithoutDuplicates = new HashSet<>(numbers);
        if (numbersWithoutDuplicates.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public PrizeCategory compareTo(WinningNumber winningNumber) {
        int matchingNumbers = 0;
        List<Integer> winningNumbers = winningNumber.getWinningNumbers();
        int bonusNumber = winningNumber.getBonusNumber();
        for (int number : winningNumbers) {
            if (this.numbers.contains(number)) {
                matchingNumbers++;
            }
        }

        if (matchingNumbers <= 2) {
            return PrizeCategory.SIXTH;
        }
        if (matchingNumbers == 3) {
            return PrizeCategory.FIFTH;
        }
        if (matchingNumbers == 4) {
            return PrizeCategory.FOURTH;
        }
        if (matchingNumbers == 5) {
            if (this.numbers.contains(bonusNumber)) {
                return PrizeCategory.SECOND;
            }
            return PrizeCategory.THIRD;
        }
        return PrizeCategory.FIRST;
    }
}
