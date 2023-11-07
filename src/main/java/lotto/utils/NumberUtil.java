package lotto.utils;

public class NumberUtil {

    public static int toLottoCount(final String purchaseAmount, final int lottoPrice) {
        int amount = Integer.parseInt(purchaseAmount);
        return amount / lottoPrice;
    }
}
