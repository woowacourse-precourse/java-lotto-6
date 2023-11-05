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

    public int compareToAnswerLotto(Lotto answerLotto) {
        return (int)numbers.stream()
                .filter(number -> answerLotto.getNumbers().contains(number))
                .count();
    }

    public boolean compareToBonusNumber(int bonusNumber) {
        return numbers.stream()
                .filter(number -> number == bonusNumber)
                .findFirst()
                .isPresent();
    }
}
