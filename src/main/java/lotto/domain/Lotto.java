package lotto.domain;

import java.util.Collections;
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
    public int getSameNumberCount(Lotto myLottoNumbers) {
        long sameNumberCount = myLottoNumbers.numbers.stream()
                .filter(numbers::contains)
                .count();

        return (int)sameNumberCount;
    }

    public boolean checkContainsSameNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public void sortedLotto(){
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        InvalidInput invalidInput = new InvalidInput();

        if (invalidInput.sizeExceededException(numbers)) {
            throw new IllegalArgumentException();
        } else if (invalidInput.duplicateNumberException(numbers)) {
            throw new IllegalArgumentException();
        } else if (invalidInput.outOfRangeException(numbers)) {
            throw new IllegalArgumentException();
        }
    }
}
