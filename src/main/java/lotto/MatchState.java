package lotto;

import java.util.Arrays;

public enum MatchState {
    MATCH_COUNT_THREE(3, 5_000),
    MATCH_COUNT_FOUR(4, 50_000),
    MATCH_COUNT_FIVE(5, 1_500_000),
    MATCH_COUNT_BONUS(5, 30_000_000),
    MATCH_COUNT_SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    MatchState(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static MatchState getMatchState(int numberOfMatch, boolean isBonus) {
        if (isBonus && numberOfMatch == 5) {
            return MATCH_COUNT_BONUS;
        }
        return Arrays.stream(values())
                .filter(matchState -> matchState.getMatchCount() == numberOfMatch)
                .findFirst()
                .orElse(null);
    }
}
