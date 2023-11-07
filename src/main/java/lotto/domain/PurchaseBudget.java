package lotto.domain;

public class Budget {
    private final int budget;
    private static final int LOTTO_PRICE = 1000;

    public Budget(int budget) {
        validate(budget);

        this.budget = budget;
    }

    private void validate(int budget) {
        if (budget < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }

        if (isNotPurchasingUnit(budget)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotPurchasingUnit(int budget) {
        return false;
    }
}
