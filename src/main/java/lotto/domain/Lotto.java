package lotto.domain;

import java.util.List;
import lotto.exception.InvalidInput;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validateBonusNumber(int bonusNumber) {
        InvalidInput invalidInput = new InvalidInput();
        invalidInput.duplicateNumberException(numbers, bonusNumber);
    }

    public int getSameNumberCount(List<Integer> myLottoNumbers) {
        long sameNumberCount = myLottoNumbers.stream()
                .filter(numbers::contains)
                .count();

        return (int)sameNumberCount;
    }

    private void validate(List<Integer> numbers) {
        InvalidInput invalidInput = new InvalidInput();

        invalidInput.sizeExceededException(numbers);
        invalidInput.duplicateNumberException(numbers);
        invalidInput.outOfRangeException(numbers);
    }

}
