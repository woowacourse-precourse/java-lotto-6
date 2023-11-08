package lotto.constants;

public enum ErrorMessage {
    NUMBER_FORMAT("로또 번호는 숫자만 입력 해야 합니다."),
    NOT_VALID_SIZE("로또 번호는 6개의 숫자를 입력 해야 합니다."),
    NOT_VALID_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_DUPLICATED("로또 번호는 중복된 숫자가 존재할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + message;
    }
}
