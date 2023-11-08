package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void play() {
        PurchaseBudget purchaseBudget = InputView.getPurchaseBudget();
        Lottos issuedLottos = OutputView.announceIssuedLottos(purchaseBudget.createQuantity());

        Lotto winningLotto = InputView.getWinningLotto();
        LottoNumber bonusLottoNumber = InputView.getBonusLottoNumber(winningLotto);

        WinnerStatistics winnerStatistic = getWinnerStatistic(issuedLottos, winningLotto, bonusLottoNumber);
        OutputView.announceWinningStatistics();
    }

    private WinnerStatistics getWinnerStatistic(Lottos issuedLottos, Lotto winningLotto, LottoNumber bonusLottoNumber) {
        MatchingResults matchingResults = issuedLottos.matchAll(winningLotto, bonusLottoNumber);

        WinnerStatistics winnerStatistics = new WinnerStatistics();
        return winnerStatistics.collect(matchingResults);
    }
}
