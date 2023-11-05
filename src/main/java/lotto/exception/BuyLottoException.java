package lotto.exception;

public class BuyLottoException {

    private static final String INTEGER_EXCEPTION_MESSAGE = "[ERROR] 로또 구입 금액은 0이상의 숫자만 가능합니다.";
    private static final String KILO_EXCEPTION_MESSAGE = "[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다.";

    public static void buyIntegerException() {
        throw new IllegalArgumentException(INTEGER_EXCEPTION_MESSAGE);
    }

    public static void buyKiloException() {
        throw new IllegalArgumentException(KILO_EXCEPTION_MESSAGE);
    }

}
