package lotto.constant;

public enum ErrorMessage {
    ERROR("[ERROR]"),
    INPUT_NUMBER_ERROR(ERROR.Message + "숫자만 입력 가능합니다."),
    INPUT_NUMBER_OVER_RANGE_ERROR(ERROR.Message + "로또 숫자의 범위의 값이 아닙니다."),
    INSUFFICIENT_PRICE_MESSAGE(ERROR.Message + "로또를 사기에 돈이 부족합니다."),
    DIVISIBILITY_CHECK_AMOUNT(ERROR.Message + "1,000원으로 나누어떨어지지 않습니다.");

    private final String Message;

    ErrorMessage(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
