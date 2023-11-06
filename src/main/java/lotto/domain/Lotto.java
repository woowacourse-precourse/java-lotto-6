package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumbers(Lotto winningNumber) {
        return (int) winningNumber.getNumbers().stream().filter(numbers::contains).count();
    }

    public boolean isBonusNumberMatch(int matchCount, int bonusNumber) {
        return matchCount == 5 && numbers.contains(bonusNumber);
    }
}
