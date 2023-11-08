package lotto.exception;

public class CheckUserInputDivideByThousand extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 입력은 1,000원 단위로 해야 합니다.";

    public CheckUserInputDivideByThousand() {
        super(ERROR_MESSAGE);
    }
}
