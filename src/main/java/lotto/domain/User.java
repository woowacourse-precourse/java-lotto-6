package lotto.domain;

public class User {

    private int money;

    public User(String money) {
        this.money = changeInteger(money);
    }

    public int getMoney() {
        return money;
    }

    private int changeInteger(String money) {
        return Integer.parseInt(money);
    }
}
