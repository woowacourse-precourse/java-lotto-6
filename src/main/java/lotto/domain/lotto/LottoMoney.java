package lotto.domain.lotto;

public class LottoMoney {

    public static final int PERCENT = 100;
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private static String PRICE_EXCEPTION_MESSAGE = String.format("[Error] Money는 %d원 단위어야 합니다", LOTTO_PRICE);
    private int money;
    public LottoMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money == ZERO || money % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(PRICE_EXCEPTION_MESSAGE);
        }
    }

    public int calculatePurchasableCount() {
        return money / LOTTO_PRICE;
    }

    public float calculateProfitRate(float winningMoney) {
        return (winningMoney / money) * PERCENT;
    }
}
