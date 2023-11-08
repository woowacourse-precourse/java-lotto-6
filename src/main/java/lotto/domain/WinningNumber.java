package lotto.domain;

import java.util.List;
import lotto.message.ConsoleMessage;

public class WinningNumber {
    private final Integer number;
    private final NumberType numberType;

    private WinningNumber(int number, NumberType numberType) {
        this.number = number;
        this.numberType = numberType;
    }

    public static WinningNumber of(Integer number, NumberType numberType) {
        validNumberRange(number);
        return new WinningNumber(number, numberType);
    }

    private static void validNumberRange(Integer number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException(ConsoleMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public Integer getWinningNum() {
        return this.number;
    }
}
