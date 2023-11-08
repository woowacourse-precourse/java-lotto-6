package controller;

import model.LottoGame;
import model.Money;
import model.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class LottoGameController {

    public void playLotto() {
        OutputView.printMoneyInputRequestMessage();
        String cost = InputView.getMoneyForLottoPurchasing();
        Money money = new Money(cost);
        LottoGame lottoGame = new LottoGame();
        lottoGame.purchaseLotto(money);
        OutputView.printPurchasingResultMessage(Integer.parseInt(cost) / 1000, lottoGame.getLottos());
        OutputView.printWinningNumberInputRequestMessage();
        String winningNumber = InputView.getWinningNumber();
        OutputView.printBonusNumberInputRequestMessage();
        String bonusNumber = InputView.getBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        Map<Integer, Integer> gameResult = lottoGame.countWinningLottoResult(winningLotto);
        OutputView.printWinningResultTitle();
        OutputView.printWinningResult(gameResult);
        System.out.println(lottoGame.calculateEarnings(gameResult));
        OutputView.printEarningRateResultMessage(lottoGame.calculateEarningRate(lottoGame.calculateEarnings(gameResult) * 100, Integer.parseInt(cost)));
    }
}
