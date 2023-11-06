package lotto.view;

import java.util.Arrays;

import lotto.model.LottoPrize;
import lotto.model.LottoStatistic;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;

public class OutputView {

    private static final String PURCHASE_RESULT = "%n%d개를 구매했습니다.%n";

    private static final String STATISTIC = "%n당첨 통계%n---%n";
    private static final String PRIZE_RESULT = "%d개 일치 (%,d원) - %d개%n";
    private static final String PRIZE_2_RESULT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    private static final String EARNING_RATE = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseResult(Lottos lottos) {
        System.out.printf(PURCHASE_RESULT, lottos.size());
        lottos.stream().forEach(System.out::println);
    }

    public void printStatistic(final PurchaseAmount amount, final LottoStatistic statistic) {
        System.out.printf(STATISTIC);
        printPrizes(statistic);
        printEarningRate(statistic, amount);
    }

    private void printPrizes(final LottoStatistic statistic) {
        Arrays.stream(LottoPrize.values())
                .filter(prize -> prize != LottoPrize.NO_PRIZE)
                .forEach(prize -> printPrize(prize, statistic));
    }

    private void printEarningRate(final LottoStatistic statistic, final PurchaseAmount amount) {
        System.out.printf(EARNING_RATE, statistic.getEarningRate(amount));
    }

    private void printPrize(final LottoPrize prize, final LottoStatistic statistic) {
        System.out.printf(
                getStatisticMessageByPrize(prize),
                prize.getMatchCount(),
                prize.getAmount(),
                statistic.getCountOf(prize)
        );
    }

    private String getStatisticMessageByPrize(final LottoPrize prize) {
        if (prize.equals(LottoPrize.PRIZE_2)) {
            return PRIZE_2_RESULT;
        }
        return PRIZE_RESULT;
    }
}