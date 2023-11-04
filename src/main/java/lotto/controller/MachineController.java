package lotto.controller;

import lotto.model.Human;
import lotto.view.PurchaseView;

public class MachineController {
    private Human human;

    public void execution() {
        initAmount();
    }

    public void initAmount() {
        int money = PurchaseView.lotto();
        human = new Human(money);
    }
}
