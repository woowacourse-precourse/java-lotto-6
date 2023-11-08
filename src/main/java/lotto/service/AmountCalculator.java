package lotto.service;

public class AmountCalculator {
    private static final int LOTTO_PRICE = 1000;
    private final int numberOfLottoPurchased;

    public AmountCalculator(int amount) {
        this.numberOfLottoPurchased = calculateNumberOfLottoPurchasedByAmount(amount);
    }

    public int getNumberOfLottoPurchased() {
        return numberOfLottoPurchased;
    }

    private int calculateNumberOfLottoPurchasedByAmount(int amount) {
        return amount / LOTTO_PRICE;
    }
}