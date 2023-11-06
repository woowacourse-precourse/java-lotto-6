package lotto.model;

import lotto.exception.NotValidInputException;

import java.util.List;

import static lotto.exception.GameExceptionMessage.*;
import static lotto.util.GameConstant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDupValidation(numbers);
        this.numbers = numbers;
    }

    protected List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != CONSTANT_LOTTO_LENGTH.getConstant()) {
            throw new NotValidInputException(INPUT_VALUE_NOT_VALID_LENGTH.getMessage());
        }
    }

    private void checkDupValidation(List<Integer> numbers) {
        long distinctValue = numbers.stream().distinct().count();

        if(numbers.size() != distinctValue) {
            throw new NotValidInputException(INPUT_VALUE_MUST_DISTINCT.getMessage());
        }
    }
}
