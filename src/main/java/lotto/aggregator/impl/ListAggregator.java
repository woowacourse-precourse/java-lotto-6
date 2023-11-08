package lotto.aggregator.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.aggregator.Aggregator;
import lotto.config.LottoConfig;
import lotto.config.LottoPrize;
import lotto.config.PrizePolicyConfig;
import lotto.lotto.AnswerLotto;
import lotto.lotto.Lotto;
import lotto.matcher.Matcher;

public class ListAggregator implements Aggregator {
    private final Matcher matcher;

    public ListAggregator(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public void aggregate(List<Lotto> results, AnswerLotto answerLotto) {
        final int original = results.size() * LottoConfig.LOTTO_COUPON_PRIZE.getNum();
        int[] numOfPrizes = new int[PrizePolicyConfig.PRIZES.getPrizes().size() + 1];
        int prizes = 0;

        for (Lotto lotto : results) {
            LottoPrize prize = matcher.match(lotto, answerLotto);
            prizes += prize.getReward();
            if (prize.getRank() < PrizePolicyConfig.PRIZES.getPrizes().size())
                numOfPrizes[prize.getRank()] += 1;
        }
        for (int i = PrizePolicyConfig.PRIZES.getPrizes().size(); i >= 1 ; i--) {
            LottoPrize lottoPrize = PrizePolicyConfig.PRIZES.getPrizes().get(i);
            System.out.printf("%d개 일치 (%d원) - %d개\n", lottoPrize.getMatchNumber(), lottoPrize.getReward(), numOfPrizes[i]);
        }

        System.out.printf("총 수익률은 %.2f입니다.", (double) prizes / original);
    }
}
