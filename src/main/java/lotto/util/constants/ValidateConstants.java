package lotto.util.constants;

public enum ValidateConstants {
    NUMERIC_REGEX("^\\d+$"),
    AMOUNT_NUMERIC_ERROR("[ERROR] 구매금액은 숫자만 입력해주세요."),
    AMOUNT_UNIT_ERROR("[ERROR] 구매금액은 1000원 단위로 입력해주세요."),
    LOTTO_NUMBER_NUMERIC_ERROR("[ERROR] 로또 번호는 숫자만 입력해주세요."),
    LOTTO_NUMBER_SIZE_ERROR("[ERROR] 로또 번호는 6개를 입력해주세요."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1 ~ 45 중에서 입력해주세요."),
    LOTTO_NUMBER_DUPLICATION_ERROR("[ERROR] 로또 번호는 중복되지 않게 입력해주세요."),
    BONUS_NUMERIC_ERROR("[ERROR] 보너스 번호는 숫자만 입력해주세요."),
    BONUS_NUMBER_RANGE_ERROR("[ERROR] 보너스 번호는 1 ~ 45 중에서 입력해주세요."),
    BONUS_NUMBER_DUPLICATE_ERROR("[ERROR] 당첨 번호에 포함 되지 않는 보너스 번호를 입력해주세요."),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_NUMBER_SIZE(6);

    private final String message;
    private final int number;

    ValidateConstants(String message) {
        this.number = 0;
        this.message = message;
    }

    ValidateConstants(int number) {
        this.number = number;
        this.message = null;
    }

    public String getConstants() {
        return message;
    }

    public int getNumberConstants() {
        return number;
    }
}
