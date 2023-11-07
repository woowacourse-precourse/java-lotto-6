package lotto.util.exception;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBER("이 숫자는 1 이상 45 이하 여야 합니다."),
    NONNEGATIVE_NUMBER("이 숫자는 양수여야 합니다."),
    NOT_DIVISIBLE_BY_UNIT("로또 한 장의 가격으로 나누어 떨어지지 않습니다."),
    NOT_INTEGER("정수가 아닙니다."),
    NOT_SIX_NUMBERS("6개의 숫자가 필요합니다."),
    HAS_DUPLICATE_NUMBER("중복된 숫자를 허용하지 않습니다."),
    WINNER_NUMBER_CONTAINS_BONUS("당첨 번호에 보너스 번호가 포함될 수 없습니다."),
    BLANK_INPUT("빈 입력은 허용하지 않습니다."),
    BLANK_ELEMENT("입력된 리스트에 빈 입력이 포함되어 있습니다."),
    INVALID_RANK("당첨 순위는 1등부터 5등까지만 가능합니다.");

    private final String message;
    private static final String convention = "[ERROR] ";
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return convention + message;
    }
}
