package lotto.message;

public enum ErrorMessage {
    NON_NUMERIC_ERROR_MESSAGE("[ERROR] 숫자를 입력해야 합니다."),
    DUPLICATE_ERROR_MESSAGE("[ERROR] 중복되지 않게 입력해야 합니다."),
    UNAVAILABLE_LENGTH_ERROR_MESSAGE("[ERROR] 6개의 숫자를 입력해야 합니다."),
    OUT_OF_RANGE_ERROR_MESSAGE("[ERROR] 1 ~ 45 사이의 숫자를 입력해야 합니다."),
    UNDER_MINIMUM_PURCHASE_AMOUNT_ERROR("[ERROR] 최소 금액은 1,000원입니다."),
    NON_DIVISIBLE_BY_THOUSAND("[ERROR] 1,000원 단위로 입력해야 합니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
