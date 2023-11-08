package lotto;

import java.util.Map;
import java.util.Map.Entry;

public class ProfitCalculator {

    public static int calculateTotalPrize(Map<LottoRank, Integer> winningResult) {
        int totalPrize = 0;

        for (Entry<LottoRank, Integer> resultEntry : winningResult.entrySet()) {
            LottoRank lottoRank = resultEntry.getKey();
            int winningNumber = resultEntry.getValue();

            totalPrize += (lottoRank.getPrizeMoney() * winningNumber);
        }

        return totalPrize;
    }
}
