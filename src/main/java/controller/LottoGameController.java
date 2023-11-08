package controller;

import exception.Exception;
import model.Lotto;
import model.LottoGame;
import model.Money;
import model.WinningLotto;
import service.LottoService;
import service.MoneyService;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class LottoGameController {

    Money money;
    MoneyService moneyService = new MoneyService();
    LottoService lottoService = new LottoService();
    LottoGame lottoGame = new LottoGame();
    Map<Integer, Integer> gameResult;

    void purchaseLottos() {
        money = moneyService.requestValidLottoPurchaseAmount();
        lottoGame.purchaseLotto(money);
        OutputView.printPurchasingResultMessage(money.getCost() / 1000, lottoGame.getLottos());
    }

    void makeLottoResult() {
        Lotto lotto = lottoService.getValidateWinningNumber();
        WinningLotto winningLotto = lottoService.getValidateBonusNumber(lotto);
        gameResult = lottoGame.countWinningLottoResult(winningLotto);
    }

    public void playLotto() {
        try {
            purchaseLottos();
        } catch (NullPointerException nullPointerException) {
            Exception.raiseInvalidInputException();
        }
        try {
            makeLottoResult();
        } catch (NullPointerException nullPointerException) {
            Exception.raiseInvalidInputException();
        }
        OutputView.printEarningRateResultMessage(gameResult, lottoGame.calculateEarningRate(lottoGame.calculateEarnings(gameResult) * 100, money.getCost()));
    }
}
