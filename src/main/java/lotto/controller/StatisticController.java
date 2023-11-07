package lotto.controller;

import lotto.domain.payment.Payment;
import lotto.domain.prize.Prize;
import lotto.domain.prize.Statistic;
import lotto.view.OutputView;

public class StatisticController {
    public Statistic createStatistic(Payment payment , Prize prize){
        int payAmount = payment.amount();
        int prizeAmount = prize.amount();

        Statistic statistic = Statistic.of(payAmount,prizeAmount);
        OutputView.printStatisticMessage(statistic);
        return statistic;
    }
}
