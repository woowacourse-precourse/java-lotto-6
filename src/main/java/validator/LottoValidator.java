package validator;

import static constant.ConstantMessage.DELIMITER;
import static constant.ConstantNumber.LOTTO_SIZE;
import static constant.ConstantNumber.MAX_NUMBER;
import static constant.ConstantNumber.MIN_NUMBER;
import static constant.ExceptionMessage.DUPLICATE_NUMBER;
import static constant.ExceptionMessage.ERROR_MESSAGE;
import static constant.ExceptionMessage.INPUT_STRING;
import static constant.ExceptionMessage.INVALID_INPUT_SIZE;
import static constant.ExceptionMessage.OUT_OF_RANGE_NUMBER;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private LottoValidator() {
    }

    public static List<Integer> isNumeric(String numbers) {
        try {
            String userInputNumbers = numbers.replace(" ", "");
            List<Integer> winningNumbers = Arrays.stream(userInputNumbers.split(DELIMITER.getMessage()))
                    .map(Integer::parseInt)
                    .toList();
            return winningNumbers;
        } catch (Exception e) {
            throw new NumberFormatException(
                    ERROR_MESSAGE.getMessage() + INPUT_STRING.getMessage()
            );
        }
    }

    public static void size(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE.getMessage() + INVALID_INPUT_SIZE.getMessage()
            );
        }
    }

    public static void duplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (Integer number : numbers) {
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException(
                        ERROR_MESSAGE.getMessage() + DUPLICATE_NUMBER.getMessage()
                );
            }
        }
    }

    public static void inRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER.getNumber() || number > MAX_NUMBER.getNumber()) {
                throw new IllegalArgumentException(
                        ERROR_MESSAGE.getMessage() + OUT_OF_RANGE_NUMBER.getMessage()
                );
            }
        }
    }
}
