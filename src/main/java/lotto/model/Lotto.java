package lotto.model;

import static lotto.util.Constants.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.Exceptions;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO) {
            throw new IllegalArgumentException();
        }
        //distinct
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != COUNT_OF_LOTTO){
            throw (new IllegalArgumentException(Exceptions.ErrorMessage.WINNINGNUM_NOT_DISTINCT));
        }
        //range check
        for (Integer num : numbers) {
            if (num < LOTTO_RANDOM_NUMBER_MIN || num > LOTTO_RANDOM_NUMBER_MAX) {
                throw new IllegalArgumentException(Exceptions.ErrorMessage.WINNINGNUM_RANGE_WRONG);
            }
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
