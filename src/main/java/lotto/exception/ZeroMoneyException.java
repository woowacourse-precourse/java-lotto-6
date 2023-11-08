package lotto.exception;

public class ZeroMoneyException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 구입금액은 0원일 수 없습니다.";

    public ZeroMoneyException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);
    }
}
