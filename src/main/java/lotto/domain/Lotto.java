package lotto.domain;

import static lotto.exception.GlobalExceptionHandler.handleCustomException;

import java.util.List;
import lotto.exception.CustomException;
import lotto.exception.ErrorCode;
import lotto.exception.GlobalExceptionHandler;
import lotto.exception.errorzip.NotSizeOfList;
import lotto.validation.NumberValidation;

public class Lotto {
    private final List<Integer> numbers;
    private static final int TARGET_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        NumberValidation.isDistinct(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != TARGET_SIZE) {
            handleCustomException(new NotSizeOfList());
        }
    }

    public List<Integer> getUserNumbers(){
        return numbers;
    }

}
