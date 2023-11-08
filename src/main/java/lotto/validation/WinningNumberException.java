package lotto.validation;

public enum WinningNumberException {
    INVALID_MULTIPLE_EXCEPTION(new IllegalArgumentException("[ERROR] 당첨 번호는 (,) 쉼표를 구분으로 입력해야 합니다.")),
    DUPLICATE_EXCEPTION(new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호에 중복된 수가 존재할 수 없습니다."));

    private final IllegalArgumentException exception;

    WinningNumberException(IllegalArgumentException exception) {
        this.exception = exception;
    }

    public IllegalArgumentException getException() {
        return exception;
    }
}
