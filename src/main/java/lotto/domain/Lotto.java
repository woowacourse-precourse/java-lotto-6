package lotto.domain;

import java.util.Collections;
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
        return Collections.unmodifiableList(numbers);
    }

    public Result compareNumberToAnswer(Answer answer) {
        int hitResult = 0;
        int bonusResult = 0;

        for (int number : numbers) {
            hitResult += searchHitNumbers(answer, number);
            bonusResult += searchBonusNumber(answer, number);
        }

        return new Result(hitResult, bonusResult);
    }

    private int searchHitNumbers(Answer answer, int number) {
        if (answer.isHitNumbersHaveThisNumber(number)) {
            return 1;
        }
        return 0;
    }

    private int searchBonusNumber(Answer answer, int number) {
        if (answer.isBonusNumberTheSameAsThis(number)) {
            return 1;
        }
        return 0;
    }
}
