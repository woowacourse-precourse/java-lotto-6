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

    public Result determineResult(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = 0;
        boolean bonusMatch = false;
        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                matchCount++;
            }
        }
        if (numbers.contains(bonusNumber)) {
            bonusMatch = true;
        }

        return new Result(matchCount, bonusMatch);
    }
}
