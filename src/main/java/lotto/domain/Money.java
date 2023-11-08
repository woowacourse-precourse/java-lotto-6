package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    private Money(final String money) {
        Validator.validationNull(money);
        Validator.validationNumber(money);
        validationChanges(money);
        this.money = Integer.parseInt(money);
    }

    public static Money from(final String money) { return new Money(money); }

    private void validationChanges(String input)  {
        if(Integer.parseInt(input) % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매 가능합니다.");
        }
    }

    public int getBuyLottoCount() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() { return money; }

}
