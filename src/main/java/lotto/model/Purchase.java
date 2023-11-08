package lotto.model;

public class Purchase {
    public static final int LOTTO_TICKET_PRICE = 1000;
    private static int amount;
    private static int count = 0;

    public Purchase(int amount) {
        validate(amount);
        Purchase.amount = amount;
        count = amount / LOTTO_TICKET_PRICE;
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
        return amount % LOTTO_TICKET_PRICE == 0;
    }

    private boolean isLessThan1000(int amount) {
        return amount >= LOTTO_TICKET_PRICE;
    }
}