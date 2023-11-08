package lotto.validator;

import java.util.Arrays;
import lotto.system.Constant;
import lotto.system.SystemMessages;

public class LottoValidator implements Validator {
    @Override
    public void check(String input) throws IllegalArgumentException {
        checkInputCount(input);
        checkNumeric(input);
        checkOutOfTypeRange(input);
        checkOutOfRange(input);
        checkDistinct(input);
    }

    private void checkInputCount(String input) {
        String[] inputs = input.split(",");
        if (inputs.length != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(SystemMessages.COUNT_NOT_EQUAL);
        }
    }

    private void checkNumeric(String input) {
        String[] inputs = input.split(",");
        try {
            Arrays.stream(inputs).forEach(Integer::parseInt);
        } catch (Exception e) {
            throw new IllegalArgumentException(SystemMessages.EACH_NOT_NUMERIC);
        }
    }

    private void checkOutOfTypeRange(String input) {
        String[] inputs = input.split(",");
        try {
            Arrays.stream(inputs).forEach(Long::parseLong);
        } catch (Exception e) {
            throw new IllegalArgumentException(SystemMessages.NUMBER_OUT_OF_TYPE_RANGE);
        }
    }

    private void checkOutOfRange(String input) {
        String[] inputs = input.split(",");
        if (Arrays.stream(inputs)
                .anyMatch(number ->
                        Long.parseLong(number) < Constant.START_INCLUSIVE ||
                                Long.parseLong(number) > Constant.END_INCLUSIVE)
        ) {
            throw new IllegalArgumentException(SystemMessages.NUMBER_EACH_OUT_OF_RANGE);
        }
    }

    private void checkDistinct(String input) {
        int distinctCount = (int) Arrays.stream(input.split(","))
                .distinct()
                .count();
        int inputCount = (int) Arrays.stream(input.split(","))
                .count();
        if (distinctCount != inputCount) {
            throw new IllegalArgumentException(SystemMessages.NUMBER_NOT_DISTINCT);
        }
    }
}
