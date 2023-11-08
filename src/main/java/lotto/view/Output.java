package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.RankConfig;

public class Output {
    public void printPurchaseCount(Integer count) {
        System.out.printf("%n" + (OutputMessage.PURCHASE_COUNT.get()) + "%n", count);
    }

    public void printLottos(List<List<Integer>> lottos) {
        System.out.println(lottos);
    }

    public void printResult(HashMap<String, Integer> count) {
        System.out.println(OutputMessage.STATISTICS);
        System.out.printf(OutputMessage.RANK.get(), RankConfig.FIFTH_BALL.get(), RankConfig.FIFTH_PRIZE.get(), count.get("fifth"));
        System.out.printf(OutputMessage.RANK.get(), RankConfig.FOURTH_BALL.get(), RankConfig.FOURTH_PRIZE.get(), count.get("fourth"));
        System.out.printf(OutputMessage.RANK.get(), RankConfig.THIRD_BALL.get(), RankConfig.THIRD_PRIZE.get(), count.get("third"));
        System.out.printf(OutputMessage.BONUS_RANK.get(), RankConfig.SECOND_BALL.get(), RankConfig.SECOND_PRIZE.get(), count.get("second"));
        System.out.printf(OutputMessage.RANK.get(), RankConfig.FIRST_BALL.get(), RankConfig.FIRST_PRIZE.get(), count.get("first"));
    }
}
