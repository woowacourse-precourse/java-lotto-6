package lotto;

import lotto.view.InputView;

public class LottoController {
    InputView inputView;
    //OutputView outputView;

    void run() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        int purchaseMoney = inputView.getPurchaseMoney();
    }

    private void getPurchaseMoney() {
        inputView.getPurchaseMoney();
    }
}
