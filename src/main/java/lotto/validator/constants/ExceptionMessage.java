package lotto.validator.constants;

public enum ExceptionMessage {
    BLANK_ERROR("[ERROR] 빈 값은 입력할 수 없습니다."),
    NOT_NUMERIC_ERROR("[ERROR] 숫자인 값만 입력 가능합니다."),
    PAY_AMOUNT_ONE_THOUSAND_UNIT_ERROR("[ERROR] 구매는 1000원 단위로만 가능합니다."),
    PAY_AMOUNT_RANGE_ERROR("[ERROR] 최대 20억까지만 구매 가능합니다.");

    private final String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
