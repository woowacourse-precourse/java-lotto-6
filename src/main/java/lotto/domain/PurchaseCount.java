package lotto.domain;

public class PurchaseCount {
    private final int value;

    public PurchaseCount(String input) {
        validate(input);
        this.value = Integer.parseInt(input) / 1000;
    }

    private void validate(String input) {
        try {
            int value = Integer.parseInt(input) / 1000;
        } catch (NumberFormatException e) {
        }
    }

    public int getValue() {
        return value;
    }
}