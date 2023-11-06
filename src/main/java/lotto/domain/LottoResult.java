package lotto.domain;

import lotto.config.LottoConfig;
import lotto.config.WinningPrize;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int PERCENTAGE = 100;
    private static final int DEFAULT = 0;
    private static final int INCREASE = 1;

    private final Map<WinningPrize, Integer> result = new HashMap<>();
    private int tryCount = DEFAULT;

    {
        for (WinningPrize prize : WinningPrize.values()) {
            result.put(prize, DEFAULT);
        }
    }

    public void apply(WinningPrize prize) {
        tryCount++;
        if (prize == null) {
            return;
        }
        result.put(prize, result.get(prize) + INCREASE);
    }

    public int getEachResult(WinningPrize prize) {
        return result.get(prize);
    }

    public float getFinalProfit() {
        float investment = tryCount * LottoConfig.PRICE.value();
        float profit = Arrays.stream(WinningPrize.values())
                .map(it -> it.prize() * getEachResult(it))
                .reduce(DEFAULT, Integer::sum);
        return  (profit / investment) * PERCENTAGE;
    }
}
