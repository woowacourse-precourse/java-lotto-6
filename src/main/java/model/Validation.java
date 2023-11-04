package model;

public class Validation {
    static final int LOTTO_PRICE = 1000;

    public int lottoPurchaseNumber(int payment) {
        return payment / LOTTO_PRICE;
    }
}
