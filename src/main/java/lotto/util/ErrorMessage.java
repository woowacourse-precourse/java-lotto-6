package lotto.util;

public enum ErrorMessage {

    INVALID_INTEGER("[ERROR]자연수를 입력해주세요."),
    EMPTY_INPUT("[ERROR]비어있는 입력입니다."),
    NOT_THOUSAND("[ERROR]1,000단위로 입력해주세요."),
    INVALID_SIZE("[ERROR]쉼표로 나누어진 6개의 숫자를 입력해주세요."),
    INVALID_RANGE("[ERROR]1부터 45사이의 숫자를 입력해주세요."),
    DUPLICATED_INPUT("[ERROR]중복되지 않은 숫자를 입력해주세요.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
