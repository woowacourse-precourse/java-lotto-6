package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Ranking {

    NONE(0
            , 0
            , (matchCount, containsBonusNumber) -> matchCount < 3),
    FIFTH(5_000
            , 3
            , (matchCount, containsBonusNumber) -> matchCount == 3),
    FOURTH(50_000
            , 4
            , (matchCount, containsBonusNumber) -> matchCount == 4),
    THIRD(1_500_000
            , 5
            , (matchCount, containsBonusNumber) -> matchCount == 5 && !containsBonusNumber),
    SECOND(30_000_000
            , 5
            , (matchCount, containsBonusNumber) -> matchCount == 5 && containsBonusNumber),
    FIRST(2_000_000_000
            , 6
            , (matchCount, containsBonusNumber) -> matchCount == 6);

    private final int money;
    private final int matchNumberCount;
    private final BiPredicate<Integer, Boolean> isMatch;

    Ranking(final int money, final int matchNumberCount, final BiPredicate<Integer, Boolean> isMatch) {
        this.money = money;
        this.matchNumberCount = matchNumberCount;
        this.isMatch = isMatch;
    }

    public static Ranking getRank(final int matchNumberCount, final boolean containsBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(rank -> rank.isMatch.test(matchNumberCount, containsBonusNumber))
                .findAny()
                .orElse(NONE);
    }

    public int getMoney() {
        return money;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }
}
