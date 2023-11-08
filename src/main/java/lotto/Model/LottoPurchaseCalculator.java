package lotto.Model;

public class LottoPurchaseCalculator {

    public static final int LOTTO_PRICE = 1000;

    public static int calculateNumberOfTickets(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }


}
