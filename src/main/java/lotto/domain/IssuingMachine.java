package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class IssuingMachine {

    private static final int LOTTO_PRICE = 1000;
    private int money;
    private List<Lotto> lottos = new ArrayList<>();

    private IssuingMachine(int money) {
        this.money = money;
    }

    public static IssuingMachine turnOn(int money) {
        return new IssuingMachine(money);
    }

    public int calculateCount() {
        validateMoney();
        return money / LOTTO_PRICE;
    }

    public void operate() {
        int count = calculateCount();
        while (count > 0) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
            count--;
        }
    }

    public Lotto createLotto() {
        Lotto lotto = new Lotto(Random.makeNumber());
        return lotto;
    }

    public List<Lotto> issueLotto() {
        operate();
        return lottos;
    }

    public void validateMoney() {

    }
}
