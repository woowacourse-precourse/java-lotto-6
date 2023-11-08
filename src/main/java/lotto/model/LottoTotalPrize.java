package lotto.model;

import lotto.model.constants.LottoWinningRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoTotalPrize {
    private final Map<LottoWinningRank, Integer> prizeCounts = new HashMap<>();

    public LottoTotalPrize() {
        init();
    }

    private void init() {
        Arrays.asList(LottoWinningRank.values())
                .forEach(winningRank ->
                        prizeCounts.put(winningRank, 0));
    }

    public void prizeCountPlus(LottoWinningRank winningRank) {
        prizeCounts.put(winningRank, prizeCounts.get(winningRank) + 1);
    }

    public Map<LottoWinningRank, Integer> getPrizeCounts() {
        return prizeCounts;
    }
}
