package lotto.controller;

import lotto.view.PurchaseView;

public class MachineController {
    public void execution() {
        initAmount();
    }

    public void initAmount() {
        System.out.println(PurchaseView.lotto());
    }
}
