package lotto.services;

public class LottoPurchaseCalculator {
    private static final int LOTTO_PRICE = 1000;

    public static int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }
}
