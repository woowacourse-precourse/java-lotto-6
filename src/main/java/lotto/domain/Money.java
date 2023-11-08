package lotto.domain;

public class Money {
    private int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getTicketQuantity() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }

    private void validateMoney(int money) {
        validateZero(money);
        validateDivide(money);
    }

    private void validateZero(int money) {
        if (money == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivide(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
