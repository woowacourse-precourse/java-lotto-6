package domain;

public enum ErrorConstants {
    INPUT_ONLY_NUMBER("[ERROR] 숫자만 입력이 가능합니다."),
    INPUT_OVER_1000("[ERROR] 금액은 1000원 이상이어야 합니다."),
    INPUT_UNIT_1000("[ERROR] 금액은 1000 단위여야합니다.");

    private final String errorMessage;

    ErrorConstants(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
