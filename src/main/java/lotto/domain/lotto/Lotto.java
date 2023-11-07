package lotto.domain.lotto;

import static lotto.util.ExceptionEnum.DUPLICATED_NUMBERS;
import static lotto.util.ExceptionEnum.INVALID_NUMBERS_SIZE;
import static lotto.util.ExceptionEnum.NUMBER_OUT_OF_RANGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int STARTINCLUSIVE = 1;
    private static final int ENDINCLUSIVE = 45;
    private static final int COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        throwIfInvalidNumbersSize(numbers);
        throwIfDuplicatedNumbers(numbers);
        throwIfNumbersOutOfRange(numbers);
    }

    private void throwIfInvalidNumbersSize(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBERS_SIZE.message());
        }
    }

    private void throwIfDuplicatedNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(DUPLICATED_NUMBERS.message());
            }
        }
    }

    private void throwIfNumbersOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!isInRange(number)) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.message());
            }
        }
    }

    private boolean isInRange(int number) {
        return number >= STARTINCLUSIVE && number <= ENDINCLUSIVE;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean hasSameNumber(int number) {
        return numbers.contains(number);
    }

    public int countWinningNumbers(List<Integer> winningNumbers) {
        int count = 0;
        for(int number : numbers){
            if(winningNumbers.contains(number)){
                count++;
            }
        }
        return count;
    }

}
