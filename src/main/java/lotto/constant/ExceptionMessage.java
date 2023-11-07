package lotto.constant;

public enum ExceptionMessage {
    ERROR("[ERROR] "),
    INVALID_NUMERIC_INPUT("숫자만 입력해주세요."),
    OUT_OF_NUMBER_RANGE("숫자가 0~9 범위를 넘어갔습니다."),
    INVALID_DIVIDE_THOUSAND("1000으로 나누어 떨어지는 수가 아닙니다."),
    INVALID_LOTTO_LENGTH("로또 번호가 6자리가 아닙니다."),
    HAS_DUPLICATE_NUMBER("중복된 숫자가 있습니다."),
    INVALID_INPUT_NULL("입력된 값이 없습니다."),
    INVALID_FORMAT("잘못된 형식을 입력하셨습니다"),
    DO_NOT_HAVE_DELIMITER(String.format("당첨 번호는 %s로 나누어 입력해주세요", LottoConstant.COMMA));

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String toMessage() {
        return ERROR.message + message;
    }
}
