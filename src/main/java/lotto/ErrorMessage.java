package lotto;

public enum ErrorMessage {
    ERROR_HEAD("[ERROR] "),
    INPUT_DUPLICATED_NUMBER_MESSAGE("중복된 숫자는 입력할 수 없습니다."),
    INVALID_NUMBER_RANGE_MESSAGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NUMBER_MESSAGE("반드시 숫자로만 입력해야 합니다."),
    INPUT_BLANK_MESSAGE("입력은 공백일 수 없습니다."),
    INPUT_EMPTY_MESSGAE("값을 입력하지 않았습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
