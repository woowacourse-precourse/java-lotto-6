package lotto.constraints;

public enum ErrorMessage {

    DUPLICATE_NUMBER("[ERROR] 중복된 숫자가 존재합니다.");

    public String getMessage() {
        return message;
    }

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
