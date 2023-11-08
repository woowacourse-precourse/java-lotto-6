package lotto.exception;

public enum ExceptionMessage {

    COUNT_EXCEPTION("[ERROR] 입력할 수 있는 당첨 번호 개수는 6개 입니다. 다시 입력하시기 바랍니다."),
    DUPLICATION_EXCEPTION("[ERROR] 중복된 숫자를 입력할 수 없습니다. 다시 입력하시기 바랍니다."),
    RANGE_EXCEPTION("[ERROR] 1이상 45이하의 숫자만 입력할 수 있습니다. 다시 입력하시기 바랍니다."),
    NON_NUMBER_EXCEPTION("[ERROR] 공백 없이 숫자만 입력할 수 있습니다. 다시 입력하시기 바랍니다."),
    INVALID_AMOUNT_FORMAT("[ERROR] 구매금액은 1,000원 단위만 입력할 수 있습니다.");

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private final String message;
}
