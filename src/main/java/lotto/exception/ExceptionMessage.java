package lotto.exception;

public enum ExceptionMessage {
    PURCHASE_UNIT_EXCEPTION("로또 구입은 1,000원 단위만 가능합니다."),
    NO_NUMBER_EXCEPTION("숫자만 입력 가능합니다."),
    INVALID_COUNT_EXCEPTION("입력 개수가 올바르지 않습니다."),
    INVALID_RANGE_EXCEPTION("숫자 범위가 올바르지 않습니다."),
    DUPLICATE_EXCEPTION("중복된 숫자가 입력되었습니다.");

    private static final String OPENING_PHRASE = "[ERROR]";
    private String message;

    ExceptionMessage(String message) {
        this.message = OPENING_PHRASE + message;
    }

    public String getMessage() {
        return this.message;
    }
}
