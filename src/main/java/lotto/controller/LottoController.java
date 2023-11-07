package lotto.controller;

import lotto.model.Coin;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;
    private final LottoMachine machine;


    public LottoController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.machine = new LottoMachine();
    }

    public void run() {
        buyLotto();
        drawWinningNumber();
        drawBonusNumber();
        resultLotto();
    }

    private void buyLotto() {
        try {
            outputView.printBuyLotto();
            int amount = inputView.readInteger();

            Coin coin = new Coin(amount);
            outputView.printNewLine();

        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            buyLotto();
        }
    }

    private void drawWinningNumber() {

    }

    private void drawBonusNumber() {

    }

    private void resultLotto() {

    }
}
