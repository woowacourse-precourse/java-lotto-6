package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum WinningCriteria {

    FIRST_PLACE(6, 2_000_000_000, (matchCount, matchBonus) -> matchCount == 6),
    SECOND_PLACE(5, 30_000_000, (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
    THIRD_PLACE(5, 1_500_000, (matchCount, matchBonus) -> matchCount == 5),
    FOURTH_PLACE(4, 50_000, (matchCount, matchBonus) -> matchCount == 4),
    FIFTH_PLACE(3, 5_000, (matchCount, matchBonus) -> matchCount == 3),
    NO_PRIZE(0, 0, (matchCount, matchBonus) -> matchCount == 0);

    private final int matchCount;
    private final BiPredicate<Integer, Boolean> matchNumbersAndBonus;
    private final int prize;

    WinningCriteria(int matchCount, int prize, BiPredicate<Integer, Boolean> matchNumbersAndBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchNumbersAndBonus = matchNumbersAndBonus;
    }

    public static WinningCriteria findRanking(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(winningCriteria -> winningCriteria.matchNumbersAndBonus.test(matchCount, matchBonus))
                .findFirst()
                .orElse(NO_PRIZE);
    }


}
