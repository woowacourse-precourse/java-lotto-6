package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final int TICKET_PRICE = 1000;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int calculateMatchingCount(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream().filter(numbers::contains).count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

