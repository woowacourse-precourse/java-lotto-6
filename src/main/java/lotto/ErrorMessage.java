package lotto;

public enum ErrorMessage {

    NUMBER("숫자를 입력해주세요.");

    private static final String ERROR = "[ERROR]";
    private final String error_message;

    ErrorMessage(String error_message) {
        this.error_message = error_message;
    }

    public String getMessage() {
        return ERROR + " " + error_message;
    }
}
