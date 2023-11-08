package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final int TICKET_PRICE = 1000;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException("로또 번호는 6개의 서로 다른 숫자여야 합니다.");
        }
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
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