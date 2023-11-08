package lotto.view;

import static lotto.message.Message.BUY_NUM;
import static lotto.message.Message.DIVIDING_LINE;
import static lotto.message.Message.WIN_STATISTICS;
import static lotto.message.Message.YIELD_RATE;

import java.util.List;
import java.util.Map;
import lotto.lotto.Lotto;
import lotto.lotto.Prize;

public class OutputView {

    private OutputView() {
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf(BUY_NUM, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printResult(Map<Prize, Long> result) {
        System.out.println(WIN_STATISTICS);
        System.out.println(DIVIDING_LINE);
        for (Prize prize : Prize.values()) {
            if (!prize.equals(Prize.NOTING)) {
                Long winNumber = result.getOrDefault(prize, 0L);
                System.out.println(prize.getDescription() + " - " + winNumber + "개");
            }
        }
    }

    public static void printYieldRate(Double yieldRate) {
        System.out.printf(YIELD_RATE, yieldRate);
    }

}
