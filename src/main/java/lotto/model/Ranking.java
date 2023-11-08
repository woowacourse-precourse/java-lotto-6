package lotto.model;


import java.util.Arrays;
import java.util.function.BiFunction;

public enum Ranking {
    FIRST(6, 2_000_000_000, (count, isBonus) -> count == 6),
    SECOND(5, 30_000_000, (count, isBonus) -> count == 5 && isBonus),
    THIRD(5, 1_500_000, (count, isBonus) -> count == 5 && !isBonus),
    FOURTH(4, 50_000, (count, isBonus) -> count == 4),
    FIFTH(3, 5_000, (count, isBonus) -> count == 3),
    NONE(-1, 0, (count, isBonus) -> count < 3);

    private final int matchCount;
    private final long reward;
    private final BiFunction<Integer, Boolean, Boolean> isMatchFunction;

    Ranking(Integer matchCount, int reward, BiFunction<Integer, Boolean, Boolean> isMatchFunction) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.isMatchFunction = isMatchFunction;
    }

    public static Ranking of(int matchCount, boolean isBonus) {
        return Arrays.stream(Ranking.values())
                .filter(rank -> rank.isMatch(matchCount, isBonus))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatch(int count, boolean isBonus) {
        return isMatchFunction.apply(count, isBonus);
    }

    public boolean isSecond() {
        return this.equals(SECOND);
    }

    public long getReward() {
        return reward;
    }

    public Integer getMatchCount() {
        return matchCount;
    }
}
