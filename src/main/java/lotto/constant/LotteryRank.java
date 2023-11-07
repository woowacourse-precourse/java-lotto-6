package lotto.constant;

import lotto.model.LotteryResult;

import java.util.AbstractMap;
import java.util.Map;

public enum LotteryRank {
    FIRST_PRIZE,
    SECOND_PRIZE,
    THIRD_PRIZE,
    FOURTH_PRIZE,
    FIFTH_PRIZE,
    ETC;

    private static final Map<LotteryResult, LotteryRank> winningCriteria = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(new LotteryResult(6, false), FIRST_PRIZE),

            new AbstractMap.SimpleEntry<>(new LotteryResult(5, true), SECOND_PRIZE),

            new AbstractMap.SimpleEntry<>(new LotteryResult(5, false), THIRD_PRIZE),
            new AbstractMap.SimpleEntry<>(new LotteryResult(4, true), THIRD_PRIZE),

            new AbstractMap.SimpleEntry<>(new LotteryResult(4, false), FOURTH_PRIZE),
            new AbstractMap.SimpleEntry<>(new LotteryResult(3, true), FOURTH_PRIZE),

            new AbstractMap.SimpleEntry<>(new LotteryResult(3, false), FIFTH_PRIZE),
            new AbstractMap.SimpleEntry<>(new LotteryResult(2, true), FIFTH_PRIZE)
    );

    public LotteryRank getLotteryRank(LotteryResult lotteryResult) {
        try {
            return winningCriteria.get(lotteryResult);
        } catch (UnsupportedOperationException exception) {
            return ETC;
        }
    }
}
