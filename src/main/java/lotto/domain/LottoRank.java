package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    NOTHING(0, 0, (matchCount, matchBonus) -> matchCount < 3),
    FIFTH(3, 5_000, (matchCount, matchBonus) -> matchCount == 3),
    FOURTH(4, 50_000, (matchCount, matchBonus) -> matchCount == 4),
    THIRD(5, 1_500_000, (matchCount, matchBonus) -> matchCount == 5 && !matchBonus),
    SECOND(5, 30_000_000, (matchCount, matchBonus) -> matchCount ==5 && matchBonus),
    FIRST(6, 2_000_000_000, (matchCount, matchBonus) -> matchCount == 6);

    private final int matchCount;
    private final int prizeAmount;
    private final BiPredicate<Integer, Boolean> matcher;

    private LottoRank(int matchCount, int prizeAmount, BiPredicate<Integer, Boolean> matcher) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.matcher = matcher;
    }

    public static LottoRank of(int matchCount, boolean matchBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matcher.test(matchCount, matchBonus))
                .findAny()
                .orElse(NOTHING);
    }

    public int calculatePrizeAmount(int count) {
        return this.prizeAmount * count;
    }

    public boolean isContainBonusRank() {
        return this.equals(SECOND);
    }

    public boolean isNotNothing() {
        return !this.equals(NOTHING);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
