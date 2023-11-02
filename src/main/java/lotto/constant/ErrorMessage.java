package lotto.constant;

public enum ErrorMessage {
    INPUT_NUMBER_ERROR("숫자만 입력 가능합니다.");

    private final String Message;

    ErrorMessage(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
