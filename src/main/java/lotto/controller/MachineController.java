package lotto.controller;

import lotto.model.Human;
import lotto.view.PurchaseView;
import lotto.view.WinningLottoView;

import java.util.List;

public class MachineController {
    private Human human;

    public void execution() {
        initAmount();
        initWinningLotto();
    }

    public void initAmount() {
        int money = PurchaseView.lotto();
        human = new Human(money);
    }

    public void initWinningLotto() {
        WinningLottoView.publish();
    }
}
