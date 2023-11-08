package lotto.exception;

public class DivideThousandException extends IllegalArgumentException {
    public static final String DIVIDE_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000의 배수여야합니다.";

    public DivideThousandException() {
        super(DIVIDE_ERROR_MESSAGE);
    }
}
