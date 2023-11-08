package lotto.exception;

public enum ErrorMessage {
    /**
     * Input Error
     */
    NOT_VALID_AMOUNT("구입 금액은 1,000원으로 나누어 떨어져야 합니다."),
    NOT_VALID_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_ENOUGH_LOTTO_LENGTH("로또는 6자리 숫자로 이루어져 있어야 합니다."),
    DUPLICATE_LOTTO_NUMBER("중복된 로또 번호가 존재합니다."),;

    private String message;

    ErrorMessage(String message) {
        String prefix = "[ERROR]";
        this.message = prefix + message;
    }

    public String getMessage() {
        return message;
    }
}
