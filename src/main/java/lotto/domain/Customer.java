package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.exception.InputMoneyException.*;
import static lotto.util.GenerateRandomList.*;

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
            buyLotto.add(new Lotto(createRandomList()));
            count += 1;
        }
    }

    public int calculateLottoNum() {
        return this.MONEY / 1000;
    }

    public List<Lotto> getAllLotto() {
        return Collections.unmodifiableList(buyLotto);
    }
}
