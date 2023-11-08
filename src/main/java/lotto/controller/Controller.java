package lotto.controller;

import lotto.model.ConfirmationWinning;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    List<Integer> winnings;
    int winningBonusNumber;
    LottoGame lottoGame = new LottoGame();
    WinningNumbers winningNumbers = new WinningNumbers();

    public void lottoGame() {
        buyLottos();
        showHowManyLottosBuy();
        putWinningNumber();
        confirmWinningResult();
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

    public void confirmWinningResult(){
        ConfirmationWinning confirmationWinning = new ConfirmationWinning(winningBonusNumber);
        List<Lotto> BunchOfLotto = lottoGame.getBunchOfLotto();
        confirmationWinning.checkWinnings(winnings,BunchOfLotto);

        showWinningsResult(confirmationWinning)
    }


    public void showWinningsResult(ConfirmationWinning confirmationWinning) {
        OutputView.printLottoResultMessage();
        confirmationWinning.showLottoGameResult(confirmationWinning.getLottoResultCount());

        showTotalRate(confirmationWinning);
    }

    public void showTotalRate(ConfirmationWinning confirmationWinning){
        int purchaseAmount = lottoGame.getPurchaseAmount();
        confirmationWinning.calculateRate(purchaseAmount);
    }
}