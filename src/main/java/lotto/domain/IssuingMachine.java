package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class IssuingMachine {

    private int money;
    private List<Lotto> lottos = new ArrayList<>();

    private IssuingMachine(int money) {
        this.money = money;
    }

    public static IssuingMachine turnOn(int money) {
        return new IssuingMachine(money);
    }

    public int calculateCount(int money) {
        return 0;
    }

    public Lotto createLotto() {
        return null;
    }

    public List<Lotto> issueLotto() {
        return null;
    }
}
