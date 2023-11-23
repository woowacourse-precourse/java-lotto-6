package lotto.exception;

public enum LottoException {
    LOTTO_DUPLICATED_BONUS_NUMBER("보너스 번호가 중복 되었습니다"),
    LOTTO_NUMBER_OUT_RANGE("로또 숫자의 범위가 1~45의 범위를 벗어났습니다"),
    LOTTO_SIZE_EXCEPTION("로또 숫자의 개수가 6개가 아닙니다."),

    MONEY_INVALID_VALUE("잘못된 값의 금액입니다."),
    CANT_SPEND_MONEY("돈을 사용할 수 없습니다"),

    INPUT_NUMBER_FORMAT("숫자를 입력해 주세요"),
    INPUT_INVALID_FORMAT("잘못된 형식의 입력입니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    LottoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }

    public IllegalArgumentException makeException() {
        return new IllegalArgumentException(getMessage());
    }
}
