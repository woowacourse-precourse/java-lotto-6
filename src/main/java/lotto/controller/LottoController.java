package lotto.controller;

import lotto.domain.Amount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String money = inputView.getPurchaseAmount();
        Amount amount = new Amount(money);
        int lottoCount = amount.getLottoCount();
        outputView.printLottoCount(lottoCount);
    }
}
