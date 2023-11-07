package lotto.controller;

import lotto.domain.Payment;
import lotto.domain.Prize;
import lotto.domain.Statistic;

public class StatisticController {
    public Statistic createStatistic(Payment payment , Prize prize){
        int payAmount = payment.amount();
        int prizeAmount = prize.amount();

        Statistic statistic = Statistic.of(payAmount,prizeAmount);

        return statistic;
    }
}
