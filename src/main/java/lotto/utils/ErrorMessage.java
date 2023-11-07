package lotto.utils;

public enum ErrorMessage {
    DEPOSIT_NOT_A_NUMBER("[ERROR] 로또 구입 금액은 1,000원 이상, 100,000원 이하의 숫자여야 합니다. "),
    DEPOSIT_NOT_A_UNIT_OF_THOUSAND("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다. "),
    DEPOSIT_OUT_OF_RANGE("[ERROR] 로또 구입 금액은 1,000원 이상, 100,000원 이하여야 합니다. ");


    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
