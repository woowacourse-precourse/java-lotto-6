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

    public int getSameNumberCount(Lotto myLottoNumbers) {
        long sameNumberCount = myLottoNumbers.numbers.stream()
                .filter(numbers::contains)
                .count();

        return (int)sameNumberCount;
    }

    public boolean checkContains(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private void validate(List<Integer> numbers) {
        InvalidInput invalidInput = new InvalidInput();

        invalidInput.sizeExceededException(numbers);
        invalidInput.duplicateNumberException(numbers);
        invalidInput.outOfRangeException(numbers);
    }

}
