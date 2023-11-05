package lotto.model;

public class PurchaseAmount {

    private int amount;
    private int times;

    public PurchaseAmount(String amount) {
        validatePurchaseAmount(amount);
        this.amount = Integer.parseInt(amount);
        this.times = this.amount / 1000;
    }

    private void validatePurchaseAmount(String amount) {
        if (!isDigit(amount) || isZeroOrMinus(amount) || isBeingDivided(amount)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDigit(String amount) {
        return amount.chars().allMatch(Character::isDigit);
    }

    private boolean isZeroOrMinus(String amount) {
        int number = Integer.parseInt(amount);
        return number <= 0;
    }

    private boolean isBeingDivided(String amount) {
        return Integer.parseInt(amount) % 1000 == 0;
    }

    public int getAmount() {
        return amount;
    }

    public int getTimes() {
        return times;
    }
}
