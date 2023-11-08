package lotto.controller;

import lotto.domain.*;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {

    public void play() {
        PurchaseBudget purchaseBudget = getPurchaseBudget();
        lineBreak();

        Lottos issuedLottos = announceIssuedLottos(purchaseBudget.createQuantity());
        lineBreak();

        Lotto winningLotto = getWinningLotto();
        lineBreak();

        LottoNumber bonusLottoNumber = getBonusLottoNumber(winningLotto);
        lineBreak();

        WinnerStatistics winnerStatistic = getWinnerStatistic(issuedLottos, winningLotto, bonusLottoNumber);
        announceWinningStatistics(winnerStatistic);
        printObject(EarningRate.of(purchaseBudget, winnerStatistic));
    }

    private WinnerStatistics getWinnerStatistic(Lottos issuedLottos, Lotto winningLotto, LottoNumber bonusLottoNumber) {
        MatchingResults matchingResults = issuedLottos.matchAll(winningLotto, bonusLottoNumber);

        WinnerStatistics winnerStatistics = new WinnerStatistics();
        return winnerStatistics.collect(matchingResults);
    }
}
