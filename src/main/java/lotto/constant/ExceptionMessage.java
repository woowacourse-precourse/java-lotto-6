package lotto.constant;

public enum ExceptionMessage {
    ERROR_TAG("[ERROR] "),
    INVALID_NUMERIC_INPUT("숫자만 입력해주세요."),
    INVALID_DIVIDE_THOUSAND(String.format("%d으로 나누어 떨어지는 수가 아닙니다.", LottoConstant.MIN_LOTTO_PRICE)),
    INVALID_LOTTO_LENGTH(String.format("로또 번호가 %d자리가 아닙니다.", LottoConstant.MAX_LOTTO_LENGTH)),
    HAS_DUPLICATE_NUMBER("중복된 숫자가 있습니다."),
    INVALID_INPUT_NULL("입력된 값이 없습니다."),
    INVALID_NULL("값이 없습니다."),
    OVER_ONE_HUNDRED_THOUSAND("100,000을 넘겨 구매할 수 없습니다."),
    DO_NOT_HAVE_DELIMITER(String.format("당첨 번호는 %s로 나누어 입력해주세요", LottoConstant.DELIMITER)),
    HAS_DUPLICATE_NUMBER_ON_LOTTO("보너스 번호는 Lotto 번호와 중복될 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String toMessage() {
        return ERROR_TAG.message + message;
    }
}
