package lotto.model;

public class Purchase {
    private static int amount;
    private static int count = 0;

    public Purchase(int amount) {
        validate(amount);
        Purchase.amount = amount;
        count = amount / 1000;
    }

    public static int getPurchaseAmount() {
        return amount;
    }

    public static int getPurchaseCount() {
        return count;
    }

    private void validate(int amount) {
        if (!isPurchaseAmountValid(amount)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isPurchaseAmountValid(int amount) {
        boolean unitOfMoneyValid = isThousandWonMultiple(amount);
        boolean minValueValid = isLessThan1000(amount);
        return unitOfMoneyValid && minValueValid;
    }

    private boolean isThousandWonMultiple(int amount) {
        return amount % 1000 == 0;
    }

    private boolean isLessThan1000(int amount) {
        return amount >= 1000;
    }
}