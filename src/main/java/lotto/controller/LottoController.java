package lotto.controller;

import lotto.model.Money;
import lotto.view.InputView;

public class LottoController {

    public void start() {
        Money money = new Money(InputView.inputBuyLottoMoney());
    }
}
