package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printRequestInputPurchaseAmountMessage();
        inputView.inputPurchaseAmount();

        outputView.printRequestInputWinningNumberMessage();
        inputView.inputWinningNumbers();

        outputView.printRequestInputBonusNumberMessage();
        inputView.inputBonusNumbers();
        
    }
}
