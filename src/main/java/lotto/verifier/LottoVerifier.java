package lotto.verifier;

import lotto.system.Constant;
import lotto.system.ExceptionMessage;

import java.math.BigInteger;
import java.util.Arrays;

public class LottoVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumberCount(input);
        checkEachNumeric(input);
        checkEachTypeRange(input);
        checkEachRange(input);
        checkDistinct(input);
    }

    private void checkNumberCount(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.COUNT_NOT_EQUAL);
        }
    }

    private void checkEachNumeric(String input) {
        String[] numbers = input.split(",");
        try {
            Arrays.stream(numbers).forEach(BigInteger::new);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.EACH_NOT_NUMERIC);
        }
    }

    private void checkEachTypeRange(String input) {
        String[] numbers = input.split(",");
        try {
            Arrays.stream(numbers).forEach(Long::parseLong);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_OUT_OF_TYPE_RANGE);
        }
    }

    private void checkEachRange(String input) {
        String[] numbers = input.split(",");

        if (Arrays.stream(numbers)
                .anyMatch(num -> Long.parseLong(num) < Constant.START_INCLUSIVE ||
                        Long.parseLong(num) > Constant.END_INCLUSIVE)
        ) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_EACH_OUT_OF_RANGE);
        }

    }

    private void checkDistinct(String input) {
        int distinctCount = (int) Arrays.stream(input.split(","))
                .distinct()
                .count();

        int inputCount = (int) Arrays.stream(input.split(","))
                .count();
        if (distinctCount != inputCount) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_NOT_DISTINCT);
        }
    }

}
