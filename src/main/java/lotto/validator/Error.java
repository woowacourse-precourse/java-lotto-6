package lotto.validator;

public enum Error {

    NOT_NUMERIC_INPUT("숫자만 입력할 수 있습니다."),
    INVALID_PAYMENT("지불 금액은 0원 이상, 1000원 단위만 가능합니다."),
    INVALID_FORMAT_WINNING_NUMBERS("당첨 번호 입력은 숫자와 , 만 가능합니다"),
    INVALID_RANGE_WINNING_NUMBER("당첨 번호와 보너스 번호는 1~45의 숫자만 가능합니다."),
    DUPLICATED_WINNING_NUMBER("당첨 번호는 중복될 수 없습니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    Error(String message) {
        this.message = PREFIX + message;
    }

    public String message() {
        return this.message;
    }
}
