package lotto.validator;

import java.util.List;
import lotto.constant.Constant;
import lotto.constant.ErrorMessage;

public class Validator {

    public static void validateLotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        boolean[] checkDuplicateNumber = new boolean[Constant.AVAILABLE_NUMBER.getValue()];
        for (int number : numbers) {
            if (number < Constant.MIN_NUMBER.getValue() || number > Constant.MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
            }
            if (checkDuplicateNumber[number]) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE.getMessage());
            }
            checkDuplicateNumber[number] = true;
        }
    }

    public static void validateLottoSize(int size) {
        if (size < Constant.MIN_LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.getMessage());
        }
    }

    public static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != Constant.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_SIZE.getMessage());
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE.getMessage());
        }
    }
}
