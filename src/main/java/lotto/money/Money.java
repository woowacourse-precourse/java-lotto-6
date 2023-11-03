package lotto.money;

public class Money {
    private static final String WRONG_MONEY = "로또는 1000원씩 구매해야 합니다.";
    private static final int LOTTO_PRICE = 1000;

    private Integer money;

    public Money(String money) {
        this.money = validate(money);
    }

    private Integer validate(String moneyEntered) {
        Integer money = Integer.valueOf(moneyEntered);
        checkCorrectUnit(money);
        return money;
    }

    private void checkCorrectUnit(Integer money) {
        if (!isDivisibleByLottoPrice(money)) {
            throw new IllegalArgumentException(WRONG_MONEY);
        }
    }

    private boolean isDivisibleByLottoPrice(Integer money) {
        return money % LOTTO_PRICE == 0;
    }
}
