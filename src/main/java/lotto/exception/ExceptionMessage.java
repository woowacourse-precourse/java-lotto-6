package lotto.exception;

public enum ExceptionMessage {
    ERROR_LOG("[ERROR]"),
    EMPTY_VALUE("공백 값을 입력할 수 없습니다.\n"),
    NOT_NUMERIC_VALUE("숫자가 아닌 값을 입력할 수 없습니다.\n"),

    DUPLICATE_NUMBER("중복된 숫자를 입력할 수 없습니다.\n"),
    INVALID_WINNING_NUMBER_FORMAT("올바르지 않은 당첨 번호 입력입니다.\n"),
    INVALID_WINNING_NUMBER_COUNT("로또 번호는 %d개 입력해야 합니다."),

    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.\n"),
    NOT_MULTIPLE_OF_THOUSAND("입력된 숫자는 1,000단위여야 합니다.\n");

    private final String message;
    
    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
