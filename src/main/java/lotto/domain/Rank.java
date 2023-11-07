package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    NOTHING(0, 0, (matchLotto, matchBonus) -> matchLotto < 3),
    FIFTH(3, 5000, (matchLotto, matchBonus) -> matchLotto == 3),
    FOURTH(4, 50000, (matchLotto, matchBonus) -> matchLotto == 4),
    THIRD(5, 1500000, (matchLotto, matchBonus) -> matchLotto == 5 && !matchBonus),
    SECOND(5, 30000000, (matchLotto, matchBonus) -> matchLotto == 5 && matchBonus),
    FIRST(6, 2000000000, (matchLotto, matchBonus) -> matchLotto == 6);

    private final int matchNums;
    private final int reward;
    private final BiPredicate<Integer, Boolean> isMatch;

    Rank(final int matchNums, final int reward, final BiPredicate<Integer, Boolean> isMatch) {
        this.matchNums = matchNums;
        this.reward = reward;
        this.isMatch = isMatch;
    }

    public static Rank findRank(final int matchLotto, final boolean matchBonus) {
        return Arrays.stream(Rank.values())
            .filter(rank -> rank.isMatch.test(matchLotto, matchBonus))
            .findAny()
            .orElse(NOTHING);
    }

    public int getReward() {
        return reward;
    }

    public int getMatchNums() {
        return matchNums;
    }
}
