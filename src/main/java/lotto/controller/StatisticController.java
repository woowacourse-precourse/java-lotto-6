package lotto.controller;

import lotto.domain.Payment;
import lotto.domain.Prize;
import lotto.domain.Statistic;
import lotto.view.OutputView;
import lotto.view.OutputViewMessage;

public class StatisticController {
    public Statistic createStatistic(Payment payment , Prize prize){
        int payAmount = payment.amount();
        int prizeAmount = prize.amount();

        Statistic statistic = Statistic.of(payAmount,prizeAmount);
        OutputView.printStatisticMessage(statistic);
        return statistic;
    }
}
