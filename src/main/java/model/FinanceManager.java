package model;

public class FinanceManager {

    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;

    private FinanceManager(final int amount) {
        this.purchaseAmount = amount;
    }

    public static FinanceManager from(final int purchase) {
        return new FinanceManager(purchase);
    }

    public static boolean isValidArgument(final String inputPurchase) {
        if (!isDigitInput(inputPurchase)) {
            return false;
        }
        int amount = Integer.parseInt(inputPurchase);

        if (!isValidUnit(amount)) {
            return false;
        }
        return true;
    }

    private static boolean isValidUnit(final int amount) {
        return amount % LOTTO_PRICE == 0;
    }

    private static boolean isDigitInput(final String inputPurchase) {
        return inputPurchase.chars()
            .allMatch(Character::isDigit);
    }

    public int calculateLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public double calculateRateOfReturn(final LottoTotalResult totalResult) {
        long resultSum=totalResult.getSum();
        return (double) resultSum /purchaseAmount*100;
    }
}
