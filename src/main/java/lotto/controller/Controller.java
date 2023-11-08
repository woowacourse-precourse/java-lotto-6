package lotto.controller;

import lotto.model.ConfirmationWinning;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {
    List<Integer> winnings;
    int winningBonusNumber;
    LottoGame lottoGame = new LottoGame();
    WinningNumbers winningNumbers = new WinningNumbers();
    ConfirmationWinning confirmationWinning = new ConfirmationWinning(winningBonusNumber);

    public void lottoGame() {
        buyLottos();
        showHowManyLottosBuy();
        putWinningNumber();
        showWinningsResult();
        showTotalRate();
    }

    public void buyLottos() {
        InputView.requestPurchaseAmount();
        lottoGame.payForLottoGame();
    }

    public void showHowManyLottosBuy() {
        lottoGame.issueLottos();
        lottoGame.showLottos();
    }

    public void putWinningNumber() {
        requestCommonWinningNumber();
        requestBonusWinningNumber();
        saveWinningNumbers();
    }

    public void requestCommonWinningNumber(){
        InputView.askCommonWinningNumbersMessage();
        winningNumbers.askCommonWinningNumbers();
    }

    public void requestBonusWinningNumber(){
        InputView.askBonusNumberMessage();
        winningNumbers.askBonusNumber();
    }

    public void saveWinningNumbers(){
        this.winnings = winningNumbers.getWinningNumbers();
        this.winningBonusNumber = winningNumbers.getBonusNumber();
    }


    public void showWinningsResult() {
        List<Lotto> lottos = lottoGame.getBunchOfLotto();
        Map<Integer, Integer> winningResult = confirmationWinning.checkWinnings(winnings,lottos);
        lottoGame.setWinningResult(winningResult);

        OutputView.printLottoResultMessage();
        confirmationWinning.showLottoGameResult(lottoGame.getWinningResult());
    }

    public void showTotalRate(){
        int purchaseAmount = lottoGame.getPurchaseAmount();
        confirmationWinning.calculateRate(purchaseAmount);
    }
}