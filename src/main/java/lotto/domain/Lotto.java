package lotto.domain;

import lotto.utils.LottoWinningStrategy;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (Integer number : uniqueNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public Result determineResult(LottoWinningStrategy winningStrategy, List<Integer> winningNumbers, int bonusNumber) {
        return winningStrategy.determineResult(numbers, winningNumbers, bonusNumber);
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }
}
