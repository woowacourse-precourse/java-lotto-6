package lotto.controller;

import lotto.domain.lotto.LottoPaper;
import lotto.domain.payment.Payment;
import lotto.domain.prize.Prize;
import lotto.domain.prize.Statistic;
import lotto.view.OutputView;
import lotto.view.OutputViewMessage;

public class StatisticController {
    public Statistic createStatistic(LottoPaper lottoPaper, Prize prize) {
        int payAmount = lottoPaper.amount();
        int prizeAmount = prize.amount();

        Statistic statistic = Statistic.of(payAmount, prizeAmount);

        OutputView.printStatisticMessage(statistic);
        return statistic;
    }

    public void printStatistic(Statistic statistic) {
        OutputView.printStatisticMessage(statistic);
    }
}
