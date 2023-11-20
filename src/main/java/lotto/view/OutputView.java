package lotto.view;

import java.util.List;
import lotto.message.ConsoleMessage;
import lotto.message.StatisticMessage;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.LottoStatistic;
import lotto.model.Lottos;

public class OutputView {
    public void showStatistic(LottoStatistic lottoStatistic) {
        System.out.print(ConsoleMessage.LINE_BREAK.getMessage());
        System.out.println(ConsoleMessage.NOTICE_STAT.getMessage());
        System.out.println(ConsoleMessage.HORIZONTAL_RULE.getMessage());

        System.out.println(StatisticMessage.FIFTH_PRIZE_STAT.getStatisticMessage() + lottoStatistic.getLottoStatistic().getOrDefault(LottoPrize.FIFTH_PRIZE, 0) + "개");
        System.out.println(StatisticMessage.FOURTH_PRIZE_STAT.getStatisticMessage() + lottoStatistic.getLottoStatistic().getOrDefault(LottoPrize.FOURTH_PRIZE, 0) + "개");
        System.out.println(StatisticMessage.THIRD_PRIZE_STAT.getStatisticMessage() + lottoStatistic.getLottoStatistic().getOrDefault(LottoPrize.THIRD_PRIZE, 0) + "개");
        System.out.println(StatisticMessage.SECOND_PRIZE_STAT.getStatisticMessage() + lottoStatistic.getLottoStatistic().getOrDefault(LottoPrize.SECOND_PRIZE, 0) + "개");
        System.out.println(StatisticMessage.FIRST_PRIZE_STAT.getStatisticMessage() + lottoStatistic.getLottoStatistic().getOrDefault(LottoPrize.FIRST_PRIZE, 0) + "개");

        System.out.println(ConsoleMessage.NOTICE_YIELD.getMessage() + lottoStatistic.getYield() + "%입니다.");
    }

    public void showLottos(Lottos lottos) {
        System.out.print(ConsoleMessage.LINE_BREAK.getMessage());
        System.out.print(lottos.getLottos().size() + ConsoleMessage.NOTICE_PURCHASE.getMessage());
        System.out.print(ConsoleMessage.LINE_BREAK.getMessage());
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
