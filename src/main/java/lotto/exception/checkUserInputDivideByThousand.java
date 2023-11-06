package lotto.exception;

public class checkUserInputDivideByThousand extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "입력은 1,000원 단위로 해야 합니다.";

    public checkUserInputDivideByThousand() {
        super(ERROR_MESSAGE);
    }
}
