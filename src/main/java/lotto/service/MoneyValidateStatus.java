package lotto.service;

public enum MoneyValidateStatus {
    PRE_MONEY_ERROR("[ERROR] 금액은 숫자만 입력 가능합니다."),
    MIN_MONEY_ERROR("[ERROR] 최소 금액은 1,000원 입니다."),
    MAX_MONEY_ERROR("[ERROR] 최대 금액은 1,000,000원 입니다."),
    UNIT_MONEY_ERROR("[ERROR] 금액은 1,000원 단위로 입력 가능합니다.");

    private String message;

    MoneyValidateStatus(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
