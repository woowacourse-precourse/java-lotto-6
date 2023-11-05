package lotto.controller;

import lotto.domain.LottoPurchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoPurchase lottoPurchase = new LottoPurchase();

    public void run() {
        purchaseLotto();
    }

    public void purchaseLotto() {
        while (true) {
            OutputView.lottoPurchaseInputMessage();
            try {
                lottoPurchase.lottoPurchaseCount(InputView.input());
                OutputView.newLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

}
