package util;

public enum ValidationBonusNumberMessages {

    NOT_A_NUMBER("[ERROR] 숫자만 입력해주세요."),
    INVALID_NUMBER("[ERROR] 숫자는 1 ~ 45 범위 이내여야 합니다.");

    private String message;

    private ValidationBonusNumberMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
