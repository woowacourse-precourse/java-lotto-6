package lotto.validation;

import java.util.Arrays;
import lotto.system.Constants;
import lotto.system.ErrorMessage;

public class LottoValidation implements Validation {
    @Override
    public void check(String input) {
        checkEachNumbersOutOfRange(input);
        checkLottoSize(input);
        checkEachNumeric(input);
        checkDuplicate(input);
    }

    private void checkEachNumbersOutOfRange(String input) {
        Arrays.stream(input.split(","))
                .mapToLong(Long::parseLong)
                .forEach(number -> {
                    if (number < Constants.START_NUMBER.getConstants()
                            || number > Constants.END_NUMBER.getConstants()) {
                        throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
                    }
                });
    }

    private void checkLottoSize(String input) {
        if (input.split(",").length != Constants.LOTTO_SIZE.getConstants()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_IS_OVER_SIZE);
        }
    }

    private void checkEachNumeric(String input) {
        try {
            Arrays.stream(input.split(","))
                    .mapToLong(Long::parseLong);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.EACH_NOT_NUMERIC);
        }
    }

    private void checkDuplicate(String input) {
        int distinctCount = (int) Arrays.stream(input.split(","))
                .distinct()
                .count();
        int inputCount = (int) Arrays.stream(input.split(","))
                .count();
        if (distinctCount != inputCount) {
            throw new IllegalArgumentException(ErrorMessage.NUM_DUPLICATION);
        }
    }
}
