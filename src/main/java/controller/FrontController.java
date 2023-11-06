package controller;

import model.MyLotto;
import view.InputView;
import view.OutPutView;

public class FrontController {

    MyLotto myLotto;

    public FrontController() {
    }

    public void run() {
        myLotto = buyLotto();
        OutPutView.printPurchaseResult(myLotto);
    }

    private MyLotto buyLotto() {
        while (true) {
            try {
                return new MyLotto(InputView.askPurchaseAmount());
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
