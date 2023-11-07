package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidateUserNumber.isLengthSix(numbers);
        ValidateUserNumber.isDuplicate(numbers);
        ValidateUserNumber.isInRange(numbers);
    }

    // TODO: 추가 기능 구현
    public boolean hasNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public boolean calculateWinNumber(int number) {
        return numbers.contains(number);
    }
}
