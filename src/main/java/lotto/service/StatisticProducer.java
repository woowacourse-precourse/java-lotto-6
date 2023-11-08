package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.Statistic;
import lotto.domain.WinningLotto;
import lotto.view.impl.StatisticView;

public class StatisticProducer {
    private LottoChecker lottoChecker;
    private Statistic statistic;
    private StatisticView statisticView;

    public StatisticProducer(LottoChecker lottoChecker, Statistic statistic, StatisticView statisticView) {
        this.lottoChecker = lottoChecker;
        this.statistic = statistic;
        this.statisticView = statisticView;
    }

    public Statistic produce(Lottos lottos, WinningLotto winningLotto, Money ticketPrice) {
        for (Lotto lotto : lottos) {
            Prize prize = lottoChecker.checkPrize(lotto, winningLotto);
            statistic.incrementPrizeCount(prize);
        }
        results(ticketPrice);
        return statistic;
    }
    public Statistic results(Money ticketPrice){
        Money totalMoneySpent = statistic.getMoneySpent(ticketPrice);

        Money totalMoneyEarned = statistic.getTotalPrizeSum();
        statistic.setBenefit(Money.mod(totalMoneyEarned, totalMoneySpent) * 100.0);

        return statistic;
    }

}
