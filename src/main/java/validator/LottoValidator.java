package validator;

import static constant.ExceptionMessage.DUPLICATE_NUMBER;
import static constant.ExceptionMessage.ERROR_MESSAGE;
import static constant.ExceptionMessage.INVALID_INPUT_SIZE;
import static constant.ExceptionMessage.OUT_OF_RANGE_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private LottoValidator() {
    }

    public static void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE.getMessage() + INVALID_INPUT_SIZE.getMessage()
            );
        }
    }

    public static void duplicateValidate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (Integer number : numbers) {
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException(
                        ERROR_MESSAGE.getMessage() + DUPLICATE_NUMBER.getMessage()
                );
            }
        }
    }

    public static void matchRangeValidate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(
                        ERROR_MESSAGE.getMessage() + OUT_OF_RANGE_NUMBER.getMessage()
                );
            }
        }
    }
}
