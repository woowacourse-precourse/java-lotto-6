package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNumber;
    private List<Integer> correctNumbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto setBonusNumber(int number) {
        this.bonusNumber = number;
        return this;
    }

    public Lotto setCorrectNumbers(List<Integer> correctNumbers) {
        this.correctNumbers = correctNumbers;
        return this;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
