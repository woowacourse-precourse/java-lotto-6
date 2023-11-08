package lotto.constants;

public enum ExceptionMessages {
    ERROR("[ERROR] "),
    INVALID_NUMBER_BUY_AMOUNT("구매 금액은 1,000원 단위 숫자 형식으로 입력하여야 합니다."),
    INVALID_BLANK_BUY_AMOUNT("구매 금액은 공백이 아닌 1,000원 단위로 입력하여야 합니다."),
    INVALID_REMAINDER_NUMBER("구매 금액은 1,000원 단위로 나누어 떨어져야 합니다."),
    INVALID_WIN_NUMBER_SIZE("로또 번호는 총 6자리를 입력하여야 합니다. ex) 1,2,3,4,5,6"),
    NOT_ALLOWED_BLANK_NUMBER("로또 번호는 공백을 입력할 수 없습니다."),
    INVALID_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    NOT_ALLOWED_DUPLICATE_NUMBER("로또 번호 6자리는 서로 다른 숫자를 입력하여야 합니다.");
    ;

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        if (ERROR.message.equals(message)) {
            return this.message;
        }
        return ERROR.message + message;
    }

}
