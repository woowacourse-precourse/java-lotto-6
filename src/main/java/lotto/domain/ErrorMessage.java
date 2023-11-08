package lotto.domain;

public enum ErrorMessage {
    MONEY_RANGE_ERROR("[ERROR] 금액은 1,000원 이상 100,000,000,000원 이하여야 합니다."),
    MONEY_UNIT_ERROR("[ERROR] 금액은 1,000원 단위여야 합니다."),

    LOTTO_SIZE_ERROR("[ERROR] 개수는 6개여야 합니다."),
    LOTTO_DUPLICATE_ERROR("[ERROR] 숫자는 중복될 수 없습니다."),
    LOTTO_RANGE_ERROR("[ERROR] 번호는 1부터 45까지여야 합니다."),

    BONUS_RANGE_ERROR("[ERROR] 번호는 1부터 45까지여야 합니다."),
    BONUS_DUPLICATE_ERROR("[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다."),

    INVALID_INPUT_ERROR("[ERROR] 입력이 올바르지 않습니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
