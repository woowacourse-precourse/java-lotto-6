package lotto.constant;

public enum ErrorMessage {
    SIZE_OF_LOTTO_IS_NOT_PROPER("번호의 개수가 6개가 아닙니다."),
    NUMBER_NOT_IN_RANGE("올바른 범위의 수가 아닙니다."),
    HAS_DUPLICATED_NUMBER("중복 값이 존재합니다."),
    NOT_PROPER_OBJECT_TYPE("올바른 객체 타입이 아닙니다."),
    NOT_PROPER_LOTTO_TICKET_PRICE("올바른 로또 구입 금액이 아닙니다.");

    private static final String MESSAGE_HEADER = "[ERROR]";
    private static final String WHITE_SPACE = " ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return MESSAGE_HEADER
                + WHITE_SPACE
                + message;
    }
}
