package lotto.domain.money;

public class Wallet {
    private final int money;

    private static final int CURRENCY = 1000;

    public Wallet(int money) {
        valid(money);
        this.money = money;
    }

    private void valid(int money) {
        if (isNegativeAmount(money) || isValidCurrency(money)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNegativeAmount(int money) {
        return money <= 0;
    }

    private boolean isValidCurrency(int money) {
        return money % CURRENCY != 0;
    }

    public int calculateCurrencyUnits() {
        return money / CURRENCY;
    }

    public float calculateProfitRatio(int profit) {
        float ratio = (float) profit / money * 100;
        return Math.round(ratio * 100) / 100f;
    }
}