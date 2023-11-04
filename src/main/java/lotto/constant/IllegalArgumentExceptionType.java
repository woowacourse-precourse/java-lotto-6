package lotto.constant;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException> {
    PARSING_NUMBER_FAIL("숫자만 입력 가능 합니다."),
    MONEY_REMAINS_EXIST("천원 단위로 입력해 주세요."),
    INSUFFICIENT_MONEY("천원 이하의 금액은 입력할 수 없습니다."),
    DUPLICATED_NUMBER_ERROR("로또에 같은 번호가 존재합니다."),
    MAX_MONEY_EXCEEDED("20억을 초과하는 금액은 입력할 수 없습니다."),
    NUMBER_AMOUNT_INVALID("로또의 번호 개수는 6개입니다."),
    WINNING_LOTTO_CONTAINS_BONUS_NUMBER("보너스 번호가 이미 당첨 번호에 포함되어 있습니다."),
    LOTTO_RANGE_ERROR("로또는 1~45사이의 번호만 입력할 수 있습니다.");

    private final String message;

    IllegalArgumentExceptionType(String message) {
        this.message = String.format(MESSAGE_FORMAT, message);
    }

    public String getMessage() {
        return message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(getMessage());
    }
}
