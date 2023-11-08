package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    FIFTH(3, 5000, (matchCount, isMatchBonus) -> matchCount == 3),
    FOURTH(4, 50000, (matchCount, isMatchBonus) -> matchCount == 4),
    THIRD(5, 1500000, (matchCount, isMatchBonus) -> matchCount == 5 && !isMatchBonus),
    SECOND(5, 30000000, (matchCount, isMatchBonus) -> matchCount == 5 && isMatchBonus),
    FIRST(6, 2000000000, (matchCount, isMatchBonus) -> matchCount == 6),
    NONE(0, 0, (matchCount, isMatchBonus) -> matchCount < 3);

    private final int matchCount;
    private final int reward;
    private final BiPredicate<Integer, Boolean> biPredicate;

    Prize(int matchCount, int reward, BiPredicate<Integer, Boolean> biPredicate) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.biPredicate = biPredicate;
    }

    public static Prize getPrize(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.biPredicate.test(matchCount, isMatchBonus))
                .findAny()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
