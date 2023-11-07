package lotto.model;

public class PurchaseMoney {
    private static final String PURCHASE_MONEY_AMOUNT_ERROR_MESSAGE = "[ERROR] 1000원 단위로 입력해주세요.";
    private static final int PRICE_PER_LOTTO = 1000;
    private long money;

    public PurchaseMoney(long insertMoney) throws IllegalArgumentException {
        validateAvailableOfPurchase(insertMoney);
        this.money = insertMoney;
    }

    static void validateAvailableOfPurchase(long insertMoney) throws IllegalArgumentException {
        if (insertMoney % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(PURCHASE_MONEY_AMOUNT_ERROR_MESSAGE);
        }
    }

    public long getMoney() {
        return this.money;
    }

    public int countOfPurchasedLotto() {
        return (int) money / PRICE_PER_LOTTO;
    }
}
