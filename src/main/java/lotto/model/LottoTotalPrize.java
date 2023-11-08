package lotto.model;

import lotto.model.constants.LottoWinningRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoTotalPrize {
    private final static int INIT_VALUE = 0;
    private final static int PLUS_COUNT = 1;

    private final Map<LottoWinningRank, Integer> prizeCounts = new HashMap<>();

    public LottoTotalPrize() {
        init();
    }

    private void init() {
        Arrays.asList(LottoWinningRank.values())
                .forEach(winningRank ->
                        prizeCounts.put(winningRank, INIT_VALUE));
    }

    public void prizeCountPlus(LottoWinningRank winningRank) {
        prizeCounts.put(winningRank, prizeCounts.get(winningRank) + PLUS_COUNT);
    }

    public Map<LottoWinningRank, Integer> getPrizeCounts() {
        return prizeCounts;
    }
}
