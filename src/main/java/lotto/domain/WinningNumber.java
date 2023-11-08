package lotto.domain;

public class WinningNumber {
    private final Integer number;
    private final NumberType numberType;

    private WinningNumber(int number, NumberType numberType) {
        this.number = number;
        this.numberType = numberType;
    }

    public static WinningNumber of(Integer number, NumberType numberType) {
        return new WinningNumber(number, numberType);
    }
}
