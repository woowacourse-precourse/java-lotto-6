package lotto.dto;

import lotto.constant.ErrorMessage;

public class LottoPurchase {
    public static final int LOTTO_PRICE = 1000;
    public static final int MAX_PURCHASE_AMOUNT = 100000;
    private final int money;

    private LottoPurchase() {
        this.money = 0;
    }

    private LottoPurchase(int money) {
        validate(money);
        this.money = money;
    }

    public static LottoPurchase from(int purchaseMoney) {
        return new LottoPurchase(purchaseMoney);
    }

    private void validate(int purchaseMoney) {
        if (purchaseMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_DIVISIBLE_AMOUNT.getMessage());
        }

        if (purchaseMoney < LOTTO_PRICE || purchaseMoney > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }
}
