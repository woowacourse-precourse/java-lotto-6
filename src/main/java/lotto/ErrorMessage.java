package lotto;

public enum ErrorMessage {
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 %d부터 %d 사이의 숫자여야 합니다."),
    LOTTO_LENGTH_ERROR("로또 번호는 중복되지 않은 %d개의 수여야 합니다."),
    MONEY_NEGATIVE_ERROR("금액은 0보다 큰 정수여야 합니다.");

    public static final String HEADER = "[ERROR]";

    private final String message;

    ErrorMessage(String bodyMessage) {
        this.message = String.format("%s %s", HEADER, bodyMessage);
    }

    public String getMessage() {
        return message;
    }
}
