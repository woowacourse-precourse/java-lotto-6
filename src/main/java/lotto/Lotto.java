package lotto;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (hasRepeatedNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasRepeatedNumbers(List<Integer> numbers) {
        Set<Integer> deletedRepeatingNumbers = new HashSet<>(numbers);

        return numbers.size() != deletedRepeatingNumbers.size();
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        int matchingNumbersCount = 0;

        for (int i = 0; i<Constants.LOTTO_NUMBER_COUNT;i++) {
            if(winningNumbers.contains(this.numbers.get(i))) {
                matchingNumbersCount ++;
            }
        }

        return matchingNumbersCount;
    }

    public boolean hasBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }
}
