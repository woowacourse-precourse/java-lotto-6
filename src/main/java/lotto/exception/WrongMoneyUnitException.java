package lotto.exception;

public class WrongMoneyUnitException extends IllegalArgumentException {

    private static final long CURRENCY_UNIT = 1000;

    public static final String ERROR_MESSAGE = String.format("[ERROR] 금액의 단위는 %d원이여야 합니다.", CURRENCY_UNIT);

    public WrongMoneyUnitException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);
    }
}
