package lotto.exception;

public class DiviedThousandException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 1,000원 단위의 금액을 입력해야합니다.";

    public DiviedThousandException() {
        super(ERROR_MESSAGE);
    }
}
