package lotto.exception;

public class InvalidPurchaseAmountException extends IllegalArgumentException {

    private static final String ERR_MSG = "[ERROR] 구입금액의 최소단위는 1000원입니다.";

    public InvalidPurchaseAmountException() {
        super(ERR_MSG);
    }
}
