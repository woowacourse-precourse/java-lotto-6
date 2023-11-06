package lotto.constant;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    INVALID_TYPE("잘못된 타입입니다"),
    INVALID_LENGTH("잘못된 길이의 당첨 번호입니다."),
    INVALID_LOTTO_RANGE("잘못된 범위의 로또 숫자입니다."),
    LOTTO_DUPLICATE("당첨 번호 중복입니다."),
    BONUS_DUPLICATE("보너스 번호 중복입니다."),
    INVALID_AMOUNT_RANGE("잘못된 범위의 금액입니다."),
    INVALID_AMOUNT_UNIT("잘못된 단위입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + message;
    }
}
