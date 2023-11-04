package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.util.NumberConverter;

public class WinningNumbers {
    private final NumberConverter numberConverter;

    public WinningNumbers(NumberConverter numberConverter) {
        this.numberConverter = numberConverter;
    }

    public void process(String numbers) {
        validateCommas(numbers);
    }

    private void validateCommas(String numbers) {
        if (numbers.startsWith(",") || numbers.endsWith(",") || numbers.contains(",,")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COMMA_USAGE.getMessage());
        }
    }

}