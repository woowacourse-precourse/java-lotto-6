package lotto;

import java.util.List;
import util.CustomIllegalArgumentException;
import util.InputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) {
        lengthVlalidator();
        numberRangeValidator();
    }

    private void lengthVlalidator() {
        InputException numberLengthException = InputException.NUMBERS_LENGTH_EXCEPTION;
        try {
            if (numbers.size() != GameProperty.LOTTO_NUMBERS_LENGTH) {
                throw new CustomIllegalArgumentException(numberLengthException);
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(numberLengthException.getMessage());
        }
    }

    private void numberRangeValidator() {
        for (int i = 0; i < numbers.size(); i++) {
            try {
                isInRange(numbers.get(i));
            } catch (IllegalArgumentException exception) {
                System.out.println(InputException.RANGE_OF_NUMBER_EXCEPTION.getMessage());
            }
        }
    }

    private void isInRange(int number) {
        if (number < GameProperty.LOTTO_MIN_NUMBER || number > GameProperty.LOTTO_MAX_NUMBER) {
            throw new CustomIllegalArgumentException(InputException.RANGE_OF_NUMBER_EXCEPTION);
        }
    }

    // TODO: 추가 기능 구현
}
