package lotto.exception;

public class NotNaturalMoneyException extends IllegalArgumentException {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static final String ERROR_MESSAGE = "[ERROR] 금액은 자연수여야 합니다.";

    public NotNaturalMoneyException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);

    }
}
