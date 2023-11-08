package lotto.exception;

public class MoneyNotTimesOfThousandException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 구입금액은 1000으로 나누어 떨어질 수 있어야 합니다.";

    public MoneyNotTimesOfThousandException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);
    }
}
