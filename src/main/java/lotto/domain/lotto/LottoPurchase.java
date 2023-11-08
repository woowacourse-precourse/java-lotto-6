package lotto.domain.lotto;

import static lotto.constant.ExceptionMessage.INPUT_MONEY_ERROR_MESSAGE;
import static lotto.constant.ExceptionMessage.INPUT_MONEY_UNIT_ERROR_MESSAGE;

public class LottoPurchase {
    private final static int MIN_AMOUNT = 0;
    private final static int AMOUNT_UNIT = 1000;
    private int money;
    private int count;

    private LottoPurchase(int money) {
        this.money = money;
        validateZeroOverMoney(money);
        validateOneThousandUnitsMoney(money);
        buyLottos();
    }

    public static LottoPurchase of(int money) {
        return new LottoPurchase(money);
    }

    public void buyLottos() {
        this.count = money / 1000;
    }

    public int getCount() {
        return count;
    }

    public double getRate(double money) {
        return money / this.money * 100;
    }


    public void validateZeroOverMoney(int money) {
        if (money <= MIN_AMOUNT) {
            throw new IllegalArgumentException(INPUT_MONEY_ERROR_MESSAGE.getMessage());
        }
    }

    public void validateOneThousandUnitsMoney(int money) {
        if (money % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(INPUT_MONEY_UNIT_ERROR_MESSAGE.getMessage());
        }
    }
}
