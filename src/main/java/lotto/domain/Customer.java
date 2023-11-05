package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.exception.InputMoneyException.*;
import static lotto.util.GenerateRandomList.*;

public class Customer {
    private final Integer MONEY;
    private final List<Lotto> buyLotto;
    private static final Integer COUNT_START = 0;
    private static final Integer COUNT_PLUS = 1;

    public Customer(String money) {
        moneyValidate(money);
        this.MONEY = Integer.parseInt(money);
        this.buyLotto = new ArrayList<>();
    }

    public void buyNewLotto() {
        int goal = calculateLottoNum();
        int count = COUNT_START;
        while (count < goal) {
            buyLotto.add(new Lotto(createRandomList()));
            count += COUNT_PLUS;
        }
    }

    public int calculateLottoNum() {
        return this.MONEY / 1000;
    }

    public List<String> getLottoTexts() {
        return buyLotto.stream()
                .map(Lotto::getLottoNumbersText)
                .toList();
    }

    public List<Lotto> getAllLotto() {
        return Collections.unmodifiableList(buyLotto);
    }
}
