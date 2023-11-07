package lotto;

import java.util.Map;
import lotto.model.Prize;

public class ComputePrizePercentTest {
    public static double computePrizePercent(Map<Prize, Integer> result, int cost) {
        double prizePercent = 0;
        for (Prize prize : result.keySet()) {
            prizePercent += Prize.getPrize(prize) * result.get(prize);
        }
        prizePercent = (prizePercent / cost) * 100;

        return prizePercent;
    }

}
