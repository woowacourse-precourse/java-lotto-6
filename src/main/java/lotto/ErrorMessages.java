package lotto;

public enum ErrorMessages {
    ERROR_NOT_NUMBER("[ERROR] 정수만 입력해 주세요"),
    ERROR_NOT_MULTIPLE_OF_THOUSAND("[ERROR] 1000의 배수를 입력해 주세요.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
