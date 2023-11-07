package message;

public enum ErrorMessage {

    LOTTO_COUNT_LIMIT("로또 번호의 개수는 6개여야 합니다."),
    CANT_DUPLICATE_NUMBER("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ONLY_CAN_NUMBER("숫자로만 입력이 가능합니다."),
    CANT_DIVIDE_AMOUNT("로또 구매 금액은 1,000원 단위여야 합니다."),
    NOT_POSITIVE_AMOUNT("로또 구매 금액은 자연수여야 합니다."),
    PREFIX("[ERROR] ");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return PREFIX.message + message;
    }
}