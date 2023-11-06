package lotto.Domain;

import java.util.List;
import lotto.Constants.ExceptionMessage;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != 6) {
            throw ExceptionMessage.SIX_NUMBER.throwexception();
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER)) {
            throw ExceptionMessage.INTPUT_NUMBER_LENGTH.throwexception();
        }
    }
}
