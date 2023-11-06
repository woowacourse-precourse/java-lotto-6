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
        int money = inputMoney();
        int quantity = money/1000;
        buyLotto(quantity);
        String[] winningNumber = getWinningNumber();
        getBonusNumber(winningNumber);
        setLottoReult();
        getLottoResult();
        getEarningRate(money);
    }

    private void getEarningRate(int inputMoney) {
        outputView.readEarningRate(inputMoney,lottoGame.getTotalEarnings());
    }

    private void getLottoResult() {
        outputView.readWinningLottoMessage();
        outputView.readWinningLottoResult(lottoGame.getResult());
    }

    private void setLottoReult() {
        lottoGame.confirmWin();
        lottoGame.setResult();
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

    private void buyLotto(int quantity) {
        outputView.readBuyLottoMessage(quantity);
        lottoGame.buy(quantity);
        outputView.readLottoNumbers(lottoGame.getLottos());
    }

    private int inputMoney() {
        inputView.readInputMoneyMessage();
        int money = inputView.inputMoney();
        return money;
    }
}
