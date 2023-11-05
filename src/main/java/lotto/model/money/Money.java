package lotto.model.money;

public class Money {
    private int money;

    Money(int money) {
        this.money = money;
    }

    public static Money create(String money) {
        return new Money(Integer.parseInt(money));
    }

    public int amountOfLotto() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
