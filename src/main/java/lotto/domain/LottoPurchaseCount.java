package lotto.domain;

public class LottoPurchaseCount {
    private static final int ONE_LOTTO_PRICE = 1000;

    public static int calculate(int lottoPurchaseAmount) {
        return lottoPurchaseAmount / ONE_LOTTO_PRICE;
    }
}
