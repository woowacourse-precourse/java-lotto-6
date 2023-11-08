package lotto.constants;

public enum PurchaseUnit {
    THOUSAND(1000);

    private final int value;

    PurchaseUnit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
