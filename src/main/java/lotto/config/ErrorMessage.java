package lotto.config;

public enum ErrorMessage {
    SPACE_OR_EMPTY("[ERROR] 공백 혹은 빈 문자열을 입력하였습니다."),
    NULL("[ERROR] Null을 입력하였습니다.")
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
