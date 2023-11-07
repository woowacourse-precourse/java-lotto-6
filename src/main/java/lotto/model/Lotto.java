package lotto.model;

import java.util.List;
import lotto.constant.Constant;
import lotto.constant.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.numbers.sort(Integer::compareTo);
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkForEachNumber(numbers);
    }

    private void checkForEachNumber(List<Integer> numbers) {
        final boolean[] checkDuplicateNumber = new boolean[Constant.AVAILABLE_NUMBER.getValue()];
        for (int number : numbers) {
            if (number < Constant.MIN_NUMBER.getValue() || number > Constant.MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.PROMPT_EXCEPTION_OUT_OF_RANGE.getMessage());
            }
            if (checkDuplicateNumber[number]) {
                throw new IllegalArgumentException(ErrorMessage.PROMPT_EXCEPTION_DUPLICATE.getMessage());
            }
            checkDuplicateNumber[number] = true;
        }
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != Constant.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.PROMPT_EXCEPTION_SIZE.getMessage());
        }
    }
}
