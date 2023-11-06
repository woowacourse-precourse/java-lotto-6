package lotto.constant;

public enum ViewConstant {

    ASK_PAYMENT_MESSAGE("구입금액을 입력해 주세요."),
    NUMBER_PATTERN("\\d+");

    private final String value;

    ViewConstant(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
