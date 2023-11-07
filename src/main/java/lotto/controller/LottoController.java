package lotto.controller;

import lotto.domain.LottoBuyer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        LottoBuyer lottoBuyer = new LottoBuyer(InputView.purchaseMoney());
        OutputView.printLottoNums(lottoBuyer.getLottos());
    }
}