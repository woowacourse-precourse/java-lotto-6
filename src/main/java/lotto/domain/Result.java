package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import lotto.global.Prize;

public class Result {
    private Map<Prize, Integer> winCounts = new HashMap<>();
    private Integer totalPrize = 0;

    public Result() {
        // initialize winCount to all has 0
        for (Prize prize : Arrays.asList(Prize.values())) {
            winCounts.put(prize, 0);
        }
    }

    public void record(Prize prize) {
        Integer winCount = winCounts.get(prize);
        winCounts.put(prize, winCount + 1);
        totalPrize += prize.getAmount();
    }

    public Integer getWinCount(Prize prize) {
        return winCounts.get(prize);
    }

    public Integer getTotalPrize() {
        return totalPrize;
    }
}
