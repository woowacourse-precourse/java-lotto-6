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
        int quantity = inputMoney();
        butLotto(quantity);
        String[] winningNumber = getWinningNumber();
        getBonusNumber(winningNumber);
        outputView.readWinningLottoMessage();
        lottoGame.confirmWin();
    }

    private void getBonusNumber(String[] winningNumber) {
        inputView.readInputBonusWinningNumberMessage();
        String bonusNumber = inputView.inputBonusWinningNumber(winningNumber);
        lottoGame.setBonusNumber(bonusNumber);
    }

    private String[] getWinningNumber() {
        inputView.readInputWinningNumberMessage();
        String[] winningNumber = inputView.inputWinningNumber();
        lottoGame.setWinningNumber(winningNumber);
        return winningNumber;
    }

    private void butLotto(int quantity) {
        outputView.readBuyLottoMessage(quantity);
        lottoGame.buy(quantity);
        outputView.readLottoNumbers(lottoGame.getLottos());
    }

    private int inputMoney() {
        inputView.readInputMoneyMessage();
        int quantity = inputView.inputMoney();
        return quantity;
    }
}
