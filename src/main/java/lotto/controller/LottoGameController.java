package lotto.controller;

import lotto.Utils;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.service.MoneyService;
import lotto.view.OutputView;
import java.util.Map;

import static lotto.model.LottoUtils.LOTTO_PRICE;

public class LottoGameController {

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
        purchaseLottos();
        makeLottoResult();
        reportLottoResult();
    }
}
