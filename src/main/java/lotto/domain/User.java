package lotto.domain;

import java.util.List;

public class User {

    Computer computer = new Computer();

    private List<Lotto> lottos;
    private int money;

    public User(String money) {
        this.money = changeInteger(money);
        lottos = computer.drawRandomNumber(this.money);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getMoney() {
        return money;
    }

    private int changeInteger(String money) {
        return Integer.parseInt(money);
    }
}
