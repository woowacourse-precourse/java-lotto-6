package lotto.model;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int lottoCount() {
        return money / LOTTO_PRICE;
    }

    private void validateMoney(int money) {
        if (money == 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000 원 이상이여야 합니다.");
        }
        if ((money % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000 원 단위로 입력해주셔야 합니다.");
        }
    }
}
