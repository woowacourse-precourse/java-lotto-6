package lotto.utils;

import java.util.HashMap;
import java.util.Map.Entry;
import lotto.domain.LottoRank;

public class LottoCaclulator {

    public static double calculateRateOfReturn(final HashMap<LottoRank, Integer> winningCount, final int money) {
        double sum = 0;
        int i = 0;
        for (Entry<LottoRank, Integer> entry : winningCount.entrySet()) {
            LottoRank rank = entry.getKey();
            int repeat = entry.getValue();
            sum += (rank.getMoney() * repeat);
            i++;
        }
        return sum / money;
    }
}
