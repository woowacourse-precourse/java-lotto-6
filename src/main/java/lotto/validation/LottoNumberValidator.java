package lotto.validation;

import lotto.view.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class LottoNumberValidator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int SIZE = 6;

    public LottoNumberValidator() {
    }


    public void run(List<Integer> numbers) {
        isValidNumbers(numbers);
        isValidSize(numbers);
        isDuplicatedNumber(numbers);
    }


    public void isValidNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            isValidNumber(number);
        }
    }

    public void isValidNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getMessage());
        }

    }

    public void isValidSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(ErrorMessage.OVER_SIZE.getMessage());
        }
    }

    public void isDuplicatedNumber(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (set.contains(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUM.getMessage());
            }
            set.add(number);
        }
    }

}
