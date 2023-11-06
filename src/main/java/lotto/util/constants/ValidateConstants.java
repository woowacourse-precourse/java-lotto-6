package lotto.util.constants;

public enum ValidateConstants {
    NUMERIC_REGEX("^\\d+$"),
    AMOUNT_NUMERIC_ERROR("[ERROR] 구매금액은 숫자만 입력해주세요."),
    AMOUNT_UNIT_ERROR("[ERROR] 구매금액은 1000원 단위로 입력해주세요."),
    WINNER_NUMBER_NUMERIC_ERROR("[ERROR] 당첨 번호는 숫자만 입력해주세요."),
    WINNER_NUMBER_SIZE_ERROR("[ERROR] 당첨 번호는 6개를 입력해주세요."),
    WINNER_NUMBER_RANGE_ERROR("[ERROR] 당첨 번호는 1 ~ 45 중에서 입력해주세요."),
    WINNER_NUMBER_DUPLICATION_ERROR("[ERROR] 당첨 번호는 1 ~ 45 중에서 입력해주세요."),
    WINNER_MIN_NUMBER(1),
    WINNER_MAX_NUMBER(45),
    WINNER_NUMBER_SIZE(6);

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
