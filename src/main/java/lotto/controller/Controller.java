package lotto.controller;

import lotto.model.ConfirmationWinning;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {
    List<Integer> winnings;
    int winningBonusNumber;
    Lottos lottoGame = new Lottos();
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
        InputView.requestWinningNumbers();
        winningNumbers.askCommonWinningNumbers();

        InputView.requestBonusNumber();
        winningNumbers.askBonusNumber();

        winnings = winningNumbers.getWinningNumbers();
        winningBonusNumber = winningNumbers.getBonusNumber();
    }

    public void showWinningsResult() {
        List<Lotto> lottos = lottoGame.getLottos();
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