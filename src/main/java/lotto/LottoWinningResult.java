package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoWinningResult {

    private Map<LottoPrize, Integer> table = new HashMap<>();

    public void addPrize(LottoPrize lottoPrize) {
        table.put(lottoPrize, table.getOrDefault(lottoPrize, 0) + 1);
    }

    public Map<LottoPrize, Integer> getTable() {
        return table;
    }
}
