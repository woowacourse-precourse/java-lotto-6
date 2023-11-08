package lotto.exception;

public enum ErrorMessage {
    /**
     * Input Error
     */
    NOT_VALID_AMOUNT("구입 금액은 1,000원으로 나누어 떨어져야 합니다."),
    NOT_VALID_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private String message;

    ErrorMessage(String message) {
        String prefix = "[ERROR]";
        this.message = prefix + message;
    }

    public String getMessage() {
        return message;
    }
}
