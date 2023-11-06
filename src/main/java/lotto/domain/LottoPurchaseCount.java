package lotto.domain;

public class LottoPurchaseCount {
    private static final int ONE_LOTTO_PRICE = 1000;

    public static int calculate(String lottoPurchaseAmount) {
        int purchaseAmount = Integer.parseInt(lottoPurchaseAmount);

        return purchaseAmount / ONE_LOTTO_PRICE;
    }
}
