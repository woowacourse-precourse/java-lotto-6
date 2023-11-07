package lotto.model;

public class LottoMoney {

    private final static int LOTTO_PRICE = 1000;
    private final static int REMAINDER_ZERO = 0;
    private final static int LIMIT_MONEY = 1000000;

    private int money;

    public LottoMoney(final int money) {
        validation(money);
        this.money = money;
    }

    private void validation(int money) {
        validateThousandUnit(money);
        validateLimit(money);
    }

    private void validateThousandUnit(int money) {
        if (money % LOTTO_PRICE > REMAINDER_ZERO) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLimit(int money) {
        if (money > LIMIT_MONEY) {
            throw new IllegalArgumentException();
        }
    }

    public int calculateCountLottoPrice() {
        return money / LOTTO_PRICE;
    }
}
