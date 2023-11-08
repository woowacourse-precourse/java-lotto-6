package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.exception.InvalidInput;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
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


    private void validate(List<Integer> numbers) {
        InvalidInput invalidInput = new InvalidInput();

        if (invalidInput.sizeExceededException(numbers)) {
            throw new IllegalArgumentException();
        } else if (invalidInput.duplicateNumbersException(numbers)) {
            throw new IllegalArgumentException();
        } else if (invalidInput.outOfRangeNumbersException(numbers)) {
            throw new IllegalArgumentException();
        }
    }

}
