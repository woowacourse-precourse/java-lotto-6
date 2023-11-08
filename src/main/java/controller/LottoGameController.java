package controller;

import model.Lotto;
import model.LottoGame;
import model.Money;
import model.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class LottoGameController {

    public void playLotto() {

        boolean isSuccess = false;
        Money money = null;
        String cost = null;
        while (!isSuccess) {
            try {
                OutputView.printMoneyInputRequestMessage();
                cost = InputView.getMoneyForLottoPurchasing();
                money = new Money(cost);
                isSuccess = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        LottoGame lottoGame = new LottoGame();
        lottoGame.purchaseLotto(money);
        OutputView.printPurchasingResultMessage(Integer.parseInt(cost) / 1000, lottoGame.getLottos());
        isSuccess = false;
        while (!isSuccess) {
            try {
                OutputView.printWinningNumberInputRequestMessage();
                String winningNumber = InputView.getWinningNumber();
                Lotto lotto =  new Lotto(winningNumber);
                isSuccess = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        isSuccess = false;
        while (!isSuccess) {
            try {
                OutputView.printBonusNumberInputRequestMessage();
                String bonusNumber = InputView.getBonusNumber();
                WinningLotto winningLotto = new WinningLotto(winningLotto.getNumbers(), bonusNumber);
                isSuccess = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Map<Integer, Integer> gameResult = lottoGame.countWinningLottoResult(winningLotto);
        OutputView.printWinningResultTitle();
        OutputView.printWinningResult(gameResult);
        System.out.println(lottoGame.calculateEarnings(gameResult));
        OutputView.printEarningRateResultMessage(lottoGame.calculateEarningRate(lottoGame.calculateEarnings(gameResult) * 100, Integer.parseInt(cost)));
    }
}
