package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.ExceptionMessages.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbersRange(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {

        if (numbers.size() != 6) {

            throw new IllegalArgumentException(NOT_VALIDATED_NUMBER_SIZE.getMessage());
        }
    }

    // TODO: 추가 기능 구현


    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateDuplicateNumber(List<Integer> numbers) {

        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_INPUT.getMessage());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {

        for (Integer number : numbers) {

            if(number > 45 || number<0) throw new IllegalArgumentException(NOT_VALIDATED_RANGE.getMessage());
        }
    }

    public int countWinningNumber(HashSet<Integer> winningNumbers) {

        int count = 0;
        for (Integer winningNumber : winningNumbers) {

            if (checkContainNumber(winningNumber)) count ++;
        }
        return count;
    }

    public boolean checkContainNumber(Integer number) {

        return this.numbers.contains(number);
    }
}
