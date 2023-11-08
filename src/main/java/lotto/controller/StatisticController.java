package lotto.controller;

import lotto.domain.lotto.LottoPaper;
import lotto.domain.prize.Prize;
import lotto.domain.prize.Statistic;

import lotto.view.OutputView;

public class StatisticController {
    public Statistic calculateStatistic(LottoPaper lottoPaper, Prize prize) {
        int payAmount = lottoPaper.amount();
        int prizeAmount = prize.amount();
        Statistic statistic = Statistic.of(payAmount, prizeAmount);
        return statistic;
    }

    public void printStatistic(Statistic statistic) {
        OutputView.printStatisticMessage(statistic);
    }
}
