package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputMoneyView;
import lotto.view.OutputLottoCountView;

public class LottoController {

    public void start() {
        Money money = getMoney();
        createLotto(money);
    }

    private Money getMoney() {
        InputMoneyView inputMoneyView = new InputMoneyView();
        int money = inputMoneyView.inputMoney();
        return new Money(money);
    }

    private void createLotto(Money money) {
        OutputLottoCountView outputLottoCountView = new OutputLottoCountView();
        outputLottoCountView.OutputLottoCount(money);
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
