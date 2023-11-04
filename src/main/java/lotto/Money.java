package lotto;

public class Money {
    private final int money;

    public Money(int money) {
        isValidMoneyFormat(money);
        isMoreThanZero(money);
        this.money = money;
    }

    private void isValidMoneyFormat(int money){
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    private void isMoreThanZero(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0보다 큰 수를 입력해야 합니다.");
        }
    }

    public int getMoney() {
        return this.money;
    }
}
