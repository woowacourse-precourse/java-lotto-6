package lotto.domain;

import java.util.List;

public class User {

    private final Computer computer;
    private final List<Lotto> lottoList;
    private final int money;

    public User(String money) {
        this.money = parseMoney(money);
        this.computer = new Computer();
        this.lottoList = computer.generateLottos(this.money);
    }

    public List<Lotto> getLottoList() {
        return List.copyOf(lottoList);
    }

    public int getMoney() {
        return money;
    }

    private int parseMoney(String money) {
        return Integer.parseInt(money);
    }
}