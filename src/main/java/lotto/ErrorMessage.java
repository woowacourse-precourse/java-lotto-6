package lotto;

public enum ErrorMessage {
    LOTTO_SIZE("[ERROR] 로또는 6개의 숫자로 구성되어야 합니다."),
    NUMBER_DUPLICATE("[ERROR] 로또에 중복되는 숫자가 있습니다."),
    NUMBER_OUT_OF_RANGE_LOW("[ERROR] 로또는 1이상의 숫자여야 합니다."),
    NUMBER_OUT_OF_RANGE_HIGH("[ERROR] 로또는 45이하의 숫자여야 합니다."),
    INVALID_TICKET_AMOUNT("[ERROR] 구입 금액은 티켓 가격 단위로 나눠떨어져야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
