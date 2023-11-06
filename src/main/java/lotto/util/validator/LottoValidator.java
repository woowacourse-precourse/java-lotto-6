package lotto.util.validator;

import java.util.List;
import lotto.util.enums.LottoNumberRange;
import lotto.util.ExceptionMessage;
import lotto.util.Util;

public class LottoValidator implements Validatable {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<Integer> numbers = Util.splitNumberByComma(input);
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateNumberDuplicate(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkNumberRange(number);
        }
    }

    private void checkNumberRange(int number) {
        if (number < LottoNumberRange.MIN_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_MIN_RANGE.getMessage());
        }
        if (number > LottoNumberRange.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_MAX_RANGE.getMessage());
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int present = numbers.get(i);
            checkNumberDuplicate(numbers, i, present);
        }
    }

    private void checkNumberDuplicate(List<Integer> numbers, int index, int present) {
        for (int i = index + 1; i < numbers.size(); i++) {
            if (Util.isEqual(present, numbers.get(i))) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_WINNING_NUMBER.getMessage());
            }
        }
    }
}
