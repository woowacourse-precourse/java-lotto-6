package lotto;

import static lotto.constant.ErrorMessage.NOT_ENOUGH_MONEY;

public class LottoPurchaseMoney {

    private static final int LOTTO_PRICE = 1000;

    private int money;

    public LottoPurchaseMoney(String inputMoney) {
        int money = Converter.stringToInt(inputMoney);
        validateEnoughMoney(money);
        this.money = money;
    }

    private void validateEnoughMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
        }
    }

}
