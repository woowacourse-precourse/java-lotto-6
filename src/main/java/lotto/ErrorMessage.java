package lotto;

public enum ErrorMessage {
    ERROR("[ERROR]"),
    WRONG_RANGE_ERROR_MESSAGE(ERROR + "로또 번호는 1~45사이의 숫자입니다."),
    WRONG_SIZE_ERROR_MESSAGE(ERROR + "로또 번호는 6개의 숫자입니다."),
    HAS_DUPLICATION_ERROR_MESSAGE(ERROR + "로또 번호에 중복이 있으면 안됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
