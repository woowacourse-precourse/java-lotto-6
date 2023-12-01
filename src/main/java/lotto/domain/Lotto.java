package lotto.domain;

import java.util.List;
import lotto.exception.ExceptionCode;
import lotto.utils.vadliator.Validator;

public class Lotto {
    public final static int SIZE = 6;
    public final static int START_NUMBER = 1;
    public final static int END_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers, ExceptionCode e) {
        validate(numbers, e);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers, ExceptionCode e) {
        numbers.forEach(number ->
                Validator.isValidRange(number, START_NUMBER, END_NUMBER, e)
        );
        Validator.isValidSize(numbers, SIZE,  e);
        Validator.isDuplication(numbers, e);
    }


}
