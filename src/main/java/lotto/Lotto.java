package lotto;

import Utils.Messages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        checkForDuplicates(numbers);
        validateRange(numbers);
    }

    // TODO: 추가 기능 구현

    public List<Integer> getLottoArray() {
        return this.numbers;
    }

    public void checkForDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(Messages.NonUniqueLottoNumberException);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(Messages.LottoNumberOutOfRangeException);
            }
        }
    }

}
