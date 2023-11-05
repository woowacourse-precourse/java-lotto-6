package lotto;

public class Money {

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getLottoCount() {
        return money / 1000;
    }

    private void validateMoney(int money) {
        if (!checkMoney(money)) {
            throw new IllegalArgumentException("1,000원으로 나누어 떨어지지 않습니다.");
        }
    }
    private boolean checkMoney(int money) {
        return money % 1000 == 0;
    }
}
