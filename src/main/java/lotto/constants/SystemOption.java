package lotto.constants;

public enum SystemOption {
    PAYMENT_UNIT_VALUE(1000);
    private int value;

    SystemOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
