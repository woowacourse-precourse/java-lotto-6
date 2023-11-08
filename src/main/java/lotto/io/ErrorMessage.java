package lotto.io;

public enum ErrorMessage {
    NOT_INTEGER("[ERROR] 입력값은 Integer 여야 합니다."),
    NOT_POSITIVE("[ERROR] 입력값은 양수 여야 합니다."),
    NOT_THOUSANDS("[ERROR] 1000 단위로 입력해야 합니다."),
    NOT_UNIQUE("[ERROR] 각 로또번호는 unique 해야 합니다"),
    INVALID_RANGE("[ERROR] 각 로또번호는 1~45사이 여야 합니다."),
    INVALID_LENGTH("[ERROR] 입력한 번호가 부족하거나 많습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}

