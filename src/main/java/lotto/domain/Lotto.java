package lotto.domain;

import java.util.List;
import lotto.exception.InvalidInput;

public class Lotto {
    private final List<Integer> numbers;
    private static boolean isValid = false;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean isValid() {
        return isValid;
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
        isValid = true;

        if (!invalidInput.sizeExceededException(numbers)) {
            isValid = false;
        } else if (!invalidInput.duplicateNumberException(numbers)) {
            isValid = false;
        } else if (!invalidInput.outOfRangeException(numbers)) {
            isValid = false;
        }
    }
}
