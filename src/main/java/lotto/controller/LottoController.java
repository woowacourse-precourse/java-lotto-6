package lotto.controller;

import lotto.domain.UserMoney;
import lotto.view.InputView;

public class LottoController {
    private UserMoney userMoney;
    public void startLotto() {
        inputMoney();
    }

    private void inputMoney() {
        int money = (int) InputView.INPUT_MONEY.activateView();
        userMoney = UserMoney.createMoney(money);
    }
}
