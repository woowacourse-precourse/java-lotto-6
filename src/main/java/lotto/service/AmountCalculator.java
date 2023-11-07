package lotto.service;

public class AmountCalculator {
    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1000;
    private final int amount;
    private final int numberOfLottoPurchased;


    public AmountCalculator(int amount) {
        validate(amount);
        this.amount = amount;
        this.numberOfLottoPurchased = calculateNumberOfLottoPurchasedByAmount(amount);

    }

    public int getNumberOfLottoPurchased() {
        return numberOfLottoPurchased;
    }

    private void validate(int amount) {
        if (amount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException();
        }
        if (amount == ZERO) {
            throw new IllegalArgumentException();
        }
    }

    private int calculateNumberOfLottoPurchasedByAmount(int amount) {
        return amount / LOTTO_PRICE;
    }
}
