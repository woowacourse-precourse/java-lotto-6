package controller;

import model.MyLotto;
import view.InputView;

public class FrontController {

    MyLotto myLotto;

    public FrontController() {
    }

    public void run() {
        myLotto = buyLotto();
    }

    private MyLotto buyLotto() {
        int purchaseAmount = InputView.askPurchaseAmount();
        return new MyLotto(purchaseAmount);
    }
}
