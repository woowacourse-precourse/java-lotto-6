package lotto.money;

public class MoneyUtils {

    private MoneyUtils() {
    }

    public static Double calculateYieldRate(Money purchaseAmount, Money earningAmount) {
        return ((double) earningAmount.getAmount() / purchaseAmount.getAmount()) * 100;
    }

}

