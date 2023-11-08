package lotto.constant;

public enum ExceptionMessage {
    NEGATIVE_NUMBER("돈은 음수이면 안됩니다"),
    OVER_NUMBER_RANGE("각 숫자는 1과 45사이여야 합니다."),
    DUPLICATED_NUMBER("중복된 숫자가 있으면 안됩니다."),
    UNDIVISIBLE_AMOUNT("구입금액은 1000원 단위여야 합니다."),
    NON_NUMERIC("문자가 아닌 숫자를 입력해야합니다"),
    ERROR_FORMAT_MESSAGE("[ERROR] ")
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
