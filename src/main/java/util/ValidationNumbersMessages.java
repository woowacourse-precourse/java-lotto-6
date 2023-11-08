package util;

public enum ValidationNumbersMessages {

    NOT_A_NUMBER("[ERROR] 숫자만 입력해주세요."),
    INVALID_LENGTH("[ERROR] , 기준으로 6개만 입력주세요."),
    INVALID_NUMBER("[ERROR] 각 숫자는 1 ~ 45 범위 이내여야 합니다.");

    private String message;

    private ValidationNumbersMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
