package lotto.domain;

import lotto.util.GenerateRandomList;

import java.util.ArrayList;
import java.util.List;

import static lotto.exception.InputMoneyException.*;

public class Customer {
    private final Integer MONEY;
    private final List<Lotto> buyLotto;

    public Customer(String money) {
        validate(money);
        this.MONEY = Integer.parseInt(money);
        this.buyLotto = new ArrayList<>();
    }

    public void buyNewLotto() {
        int goal = calculateLottoNum();
        int count = 0;
        while (count < goal) {
            buyLotto.add(new Lotto(GenerateRandomList.createRandomList()));
            count += 1;
        }
    }

    public int calculateLottoNum() {
        return this.MONEY / 1000;
    }


}
