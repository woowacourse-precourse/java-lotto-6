package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {

    NO_PRIZE(0, 0, (matchCount, matchBonus) -> matchCount == 0),
    FIFTH_PLACE(3, 5_000, (matchCount, matchBonus) -> matchCount == 3),
    FOURTH_PLACE(4, 50_000, (matchCount, matchBonus) -> matchCount == 4),
    THIRD_PLACE(5, 1_500_000, (matchCount, matchBonus) -> matchCount == 5 && !matchBonus),
    SECOND_PLACE(5, 30_000_000, (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
    FIRST_PLACE(6, 2_000_000_000, (matchCount, matchBonus) -> matchCount == 6);

    private final int matchCount;
    private final BiPredicate<Integer, Boolean> matchNumbersAndBonus;
    private final int prizeMoney;

    Prize(int matchCount, int prizeMoney, BiPredicate<Integer, Boolean> matchNumbersAndBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.matchNumbersAndBonus = matchNumbersAndBonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static Prize findPrize(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchNumbersAndBonus.test(matchCount, matchBonus))
                .findFirst()
                .orElse(NO_PRIZE);
    }


}
