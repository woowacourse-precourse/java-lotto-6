package lotto.exception;

public enum ExceptionMessage {
    INVALID_MONEY_FORMAT("구입 금액이 숫자가 아닙니다."),
    UNIT_ERROR("구입 금액은 1,000원 단위여야 합니다."),
    ZERO_VALUE("구입 금액을 0원보다 높게 입력하세요."),

    INVALID_LOTTO_FORMAT("당첨 번호는 쉼표로 구분된 숫자여야 합니다."),
    INVALID_SIZE("당첨 번호는 6개여야 합니다."),
    DUPLICATED_NUMBERS("당첨 번호가 중복되었습니다."),
    NUMBERS_OUT_OF_RANGE("로또 번호는 1~45여야 합니다."),

    INVALID_BONUS_NUMBER_FORMAT("보너스 번호가 숫자가 아닙니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1~45여야 합니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호가 당첨 번호와 중복됩니다.");


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
