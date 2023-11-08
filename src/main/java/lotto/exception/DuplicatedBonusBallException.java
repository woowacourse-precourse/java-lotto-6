package lotto.exception;

public class DuplicatedBonusBallException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE =
            CommonExceptionMessage.PREFIX_EXCEPTION.getMessage() + "보너스 볼은 정답 볼과 다른 수여야 합니다.";

    public DuplicatedBonusBallException() {
        super(ERROR_MESSAGE);
    }
}
