package lotto.domain;

import java.util.List;
import lotto.exception.InvalidInput;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validateBonusNumber(int bonusNumber) {
        InvalidInput invalidInput = new InvalidInput();
        invalidInput.duplicateNumberException(numbers, bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        InvalidInput invalidInput = new InvalidInput();

        invalidInput.sizeExceededException(numbers);
        invalidInput.duplicateNumberException(numbers);
        invalidInput.outOfRangeException(numbers);
    }

    public int getSameNumberCount(List<Integer> myLottoNumber) {
        long sameNumberCount = myLottoNumber.stream()
                .filter(numbers::contains)
                .count();

        return (int)sameNumberCount;
    }
}
