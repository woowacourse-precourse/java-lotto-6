package lotto.domain;

import lotto.domain.enumerte.NumberType;
import lotto.message.ConsoleMessage;

public class WinningNumber {
    private final Integer number;
    private final NumberType numberType;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private WinningNumber(int number, NumberType numberType) {
        this.number = number;
        this.numberType = numberType;
    }

    public static WinningNumber of(Integer number, NumberType numberType) {
        validNumberRange(number);
        return new WinningNumber(number, numberType);
    }

    private static void validNumberRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ConsoleMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public Integer getWinningNum() {
        return this.number;
    }
    public NumberType getWinningType() {
        return this.numberType;
    }
}
