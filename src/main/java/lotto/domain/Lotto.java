package lotto.domain;

import java.util.List;
import lotto.exception.CustomException;
import lotto.exception.ErrorCode;
import lotto.exception.GlobalExceptionHandler;

public class Lotto {
    private final List<Integer> numbers;
    private static final int TARGET_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != TARGET_SIZE) {
            GlobalExceptionHandler.handleCustomException(new CustomException(ErrorCode.NOT_SIX_SIZE_OF_LIST));
        }
    }

    public List<Integer> getUserNumbers(){
        return numbers;
    }
}
