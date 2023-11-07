package lotto.constant;

public enum ExceptionMessages {
    PURCHASE_AMOUNT_FORMAT_EXCEPTION_MESSAGE("구입금액은 양의 정수여야 합니다.");

    private String value;

    private ExceptionMessages(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
