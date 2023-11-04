package lotto.controller;

import lotto.model.PurchaseLotto;
import lotto.view.InputView;

public class DrawController {

    public void draw() {
        System.out.println("구입금액을 입력해 주세요.");
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        purchaseLotto.purchase(InputView.input());
    }
}
