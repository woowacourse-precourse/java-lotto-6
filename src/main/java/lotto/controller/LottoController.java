package lotto.controller;

import lotto.domain.cash.Cash;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private Cash purchaseCash;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        inputPurchaseCash();
    }

    private void inputPurchaseCash() {
        // 구입금액을 입력해 주세요.
        try {
            purchaseCash = new Cash(inputView.inputNumber());
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            inputPurchaseCash();
        }
    }

}
