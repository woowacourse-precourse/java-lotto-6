package lotto.service;

import lotto.model.Money;

public class LottoGameService {
    Money money;

    public void buyLotto(String inputMoney) {
        money = new Money(inputMoney);
    }

}
