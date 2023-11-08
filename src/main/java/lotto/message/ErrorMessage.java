package lotto.message;

public enum ErrorMessage {
    LOTTO_SIZE("로또는 6개의 숫자로 구성되어야 합니다."),
    NUMBER_DUPLICATE("로또에 중복되는 숫자가 있습니다."),
    NUMBER_OUT_OF_RANGE_LOW("로또는 1이상의 숫자여야 합니다."),
    NUMBER_OUT_OF_RANGE_HIGH("로또는 45이하의 숫자여야 합니다."),
    INVALID_TICKET_AMOUNT("구입 금액은 티켓 가격 단위로 나눠떨어져야 합니다."),
    NULL_STRING("아무 입력이 들어오지 않았습니다"),
    CHAR_STRING("문자가 포함되어 있습니다."),
    DUPLICATE_WITH_LOTTO("보너스 숫자가 로또 넘버와 중복됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
