package controller;

import exception.Exception;
import lotto.Utils;
import model.Lotto;
import model.LottoGame;
import model.Money;
import model.WinningLotto;
import service.LottoService;
import service.MoneyService;
import view.OutputView;
import java.util.Map;

public class LottoGameController {

    private static final int LOTTO_PRICE = 1000;
    Money money;
    MoneyService moneyService = new MoneyService();
    LottoService lottoService = new LottoService();
    LottoGame lottoGame = new LottoGame();
    Map<Integer, Integer> gameResult;

    void purchaseLottos() {
        money = moneyService.requestValidLottoPurchaseAmount();
        lottoGame.purchaseLotto(money);
        OutputView.printPurchasingResultMessage(money.getCost() / LOTTO_PRICE, lottoGame.getLottos());
    }

    void makeLottoResult() {
        Lotto lotto = lottoService.getValidateWinningNumber();
        WinningLotto winningLotto = lottoService.getValidateBonusNumber(lotto);
        gameResult = lottoGame.countWinningLottoResult(winningLotto);
    }

    void reportLottoResult() {
        String earningRate = Utils.formatAndRoundNumber(lottoGame.calculateEarningRate(gameResult, money.getCost()));
        OutputView.printLottoResult(gameResult, earningRate);
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
        reportLottoResult();
}
}
