package lotto.constants;

public enum Error {
    NUMERIC_INVALID("[ERROR] 숫자만 입력해 주세요."),
    MINIMUM_INVALID("[ERROR] 최소 금액은 1,000원 입니다."),
    DIVIDE_INVALID("[ERROR] 1,000원 단위로 입력해주세요.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
