package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Ranking {

    FAIL(-1, 0, (matchCount, containBonusNumber) -> matchCount == 0),
    FIFTH(3, 5000, (matchCount, containBonusNumber) -> matchCount == 3),
    FOURTH(4, 50000, (matchCount, containBonusNumber) -> matchCount == 4),
    THIRD(5, 1500000, (matchCount, containBonusNumber) -> matchCount == 5 && !containBonusNumber),
    SECOND(5, 30000000, (matchCount, containBonusNumber) -> matchCount == 5 && containBonusNumber),
    FIRST(6, 2000000000, (matchCount, containBonusNumber) -> matchCount == 6);
    private final int matchCount;
    private final int reward;
    private final BiPredicate<Integer, Boolean> isMatch;

    Ranking(int matchCount, int reward, BiPredicate<Integer, Boolean> isMatch) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.isMatch = isMatch;
    }

    public static Ranking getRanking(int matchCount, boolean containBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.isMatch.test(matchCount, containBonusNumber))
                .findAny()
                .orElse(FAIL);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
