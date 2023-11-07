package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputMoneyView;

public class LottoController {

    public void start() {
        Money money = getMoney();
        Lottos lottos = createLotto();
    }

    private Money getMoney() {
        InputMoneyView inputMoneyView = new InputMoneyView();
        int money = inputMoneyView.inputMoney();
        return new Money(money);
    }

    private Lottos createLotto() {

    }

    private void getNumber() {

    }

    private void getBonusNumber() {

    }

    private void calculateWin() {

    }

    private void calculateRate() {

    }
}
