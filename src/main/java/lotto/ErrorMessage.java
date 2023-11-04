package lotto;

public enum ErrorMessage {
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 %d부터 %d 사이의 숫자여야 합니다."),
    LOTTO_LENGTH_ERROR("로또 번호는 %d개여야 합니다."),
    LOTTO_DUPLICATE_ERROR("로또 번호에는 중복된 숫자가 있을 수 없습니다.");

    public static final String HEADER = "[ERROR]";

    private final String message;

    ErrorMessage(String bodyMessage) {
        this.message = String.format("%s %s", HEADER, bodyMessage);
    }

    public String getMessage() {
        return message;
    }
}
