package lotto.domain;

import lotto.util.ExceptionHandling;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ExceptionHandling.isSameNumber(numbers);
        ExceptionHandling.isOverSize(numbers);
        ExceptionHandling.isNumberOverRange(numbers);
    }

    public int countMatchingNumbers(List<Integer> winningNumber) {
        return (int) numbers.stream()
                .distinct()
                .filter(winningNumber::contains)
                .count();
    }

    public boolean isContainBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
