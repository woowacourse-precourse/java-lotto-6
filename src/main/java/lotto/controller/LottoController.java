package lotto.controller;

import lotto.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView;
    OutputView outputView;
    LottoGame lottoGame;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoGame = new LottoGame();
    }

    public void start() {
        inputView.readInputMoneyMessage();
        int quantity = inputView.inputMoney();
        outputView.readBuyLottoMessage(quantity);
        lottoGame.buy(quantity);
        outputView.readLottoNumbers(lottoGame.getLottos());
        inputView.readInputWinningNumberMessage();
        String[] winningNumber = inputView.inputWinningNumber();
        inputView.readInputBonusWinningNumberMessage();
        inputView.inputBonusWinningNumber();
    }
}
