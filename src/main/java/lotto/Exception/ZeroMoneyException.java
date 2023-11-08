package lotto.Exception;

public class ZeroMoneyException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 입력이 0보다 커야합니다.";

    public ZeroMoneyException(){
        super(ERROR_MESSAGE);
    }
}
