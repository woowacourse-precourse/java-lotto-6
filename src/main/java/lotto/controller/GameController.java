package lotto.controller;

import lotto.domain.*;
import lotto.utility.RandomNumber;
import lotto.validation.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

import static lotto.utility.RetryLogic.*;

public class GameController {

    private static final int LOTTO_PRICE = 1000;
    int amount; //로또 구입 총액
    int count; //로또 발행 개수

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RandomNumber randomNumber = new RandomNumber();
    WinningLotto winningLotto = new WinningLotto();
    Validator validator = new Validator();

    public void proceed() {
        init();
        LottoPublish();
        winningLotto();
    }

    private void winningLotto() {
        retryCount(() -> winningLotto.setWinningLotto(inputView.printWinningNumber()));
        retryCount(() -> winningLotto.setBonusNumber(inputView.printBonusNumber()));

        winningStatistics();
    }

    private void winningStatistics() {
        winningLotto.getCollectLottoNumber();
        Map<Statistics, Integer> winningCount = winningLotto.getWinningCount();
        outputView.printWinningStatistics(Statistics.statisticsResult(winningCount));
        outputView.printRateOfReturn(winningLotto.rateOfReturn(amount));
    }

    private void LottoPublish() {
        LottoHistory lottoHistory = new LottoHistory();
        for (int i = 0; i < count; i++) {
            Lotto.createLotto(randomNumber.makeLottoNumber());
        }
        outputView.printLottoHistory(lottoHistory.getLottoHistory());
    }

    private void init() {
        LottoStore.getInstance().getLotto().clear();
        retryCount(() -> amount = validator.validPurchase(inputView.printPurchaseAmount()));
        count = amount / LOTTO_PRICE;
        outputView.printPurchase(count);
    }


}
