package lotto.domain;

public class PurchaseCount {
    private final int value;

    public PurchaseCount(int input) {
        validate(input);
        this.value = input/1000;
    }

    private void validate(int input) {
    }

    public int getValue() {
        return value;
    }
}