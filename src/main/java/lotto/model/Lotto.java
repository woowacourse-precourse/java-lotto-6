package lotto.model;

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

    public boolean containBonusNumber(int number) {
        return numbers.contains(number);
    }

    public int removeNonCommonNumber(List<Integer> winningNumbers) {
        numbers.retainAll(winningNumbers);
        return numbers.size();
    }
}
