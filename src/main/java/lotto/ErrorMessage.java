package lotto;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR] "),
    INDIVISIBLE_NUMBER("나누어 떨어지지 않는 금액 단위입니다."),
    ZERO_NUMBER("0원이 입력 됐습니다."),
    NOT_NUMBER_FORMAT("숫자가 아닌 돈이 입력 됐습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE + message;
    }
}
