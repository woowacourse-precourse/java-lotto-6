package lotto.service;

import lotto.domain.*;
import lotto.view.OutputView;

import java.util.Map;

public class RankingService {
    private final WinningLotto winningLotto;
    private final Lottos lottos;
    private final Money money;

    public RankingService(WinningLotto winningLotto, Lottos lottos, Money money) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
        this.money = money;
    }

    public void result() {
        OutputView.printResultMessage();
        printRankingCount();
        Result result = setResult();
        printRateOfReturn(result);
    }

    private void printRankingCount() {
        Map<Ranking, Integer> rankingCount = setRankingCount();
        rankingCount.forEach((ranking, count) -> {
            String message = ranking.getMessage();
            OutputView.printCount(message, count);
        });
    }

    private Map<Ranking, Integer> setRankingCount() {
        Lotto winnigLotto = winningLotto.winningLotto();
        int bonus = winningLotto.bonus();
        return lottos.countRankings(winnigLotto, bonus);
    }

    private Result setResult() {
        Map<Ranking, Integer> rankingCount = setRankingCount();
        return new Result(rankingCount);
    }

    public void printRateOfReturn(Result result) {
        int purchaseMoney = money.purchaseMoney();
        double rateOfReturn = result.getRateOfReturn(purchaseMoney);
        OutputView.printRateOfReturn(rateOfReturn);
    }
}
