package lotto.constant;

import java.util.Arrays;

public enum Rank {
    NO_MATCH(0, 0, false, "0개 일치 (0원) - "),
    THREE_MATCH(3, 5000, false, "3개 일치 (5,000원) - "),
    FOUR_MATCH(4, 50000, false, "4개 일치 (50,000원) - "),
    FIVE_MATCH_NOT_BONUS(5, 1500000, false, "5개 일치 (1,500,000원) - "),
    FIVE_MATCH_PLUS_BONUS(5, 30000000, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCH(6, 2000000000, false, "6개 일치 (2,000,000,000원) - ");

    public final int match;
    public final int prizeMoney;
    public final boolean needBonus;
    public final String message;

    Rank(int match, int prizeMoney, boolean needBonus, String message) {
        this.match = match;
        this.prizeMoney = prizeMoney;
        this.needBonus = needBonus;
        this.message = message;
    }

    private static Rank getInstance(long totalCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.match == totalCount)
                .findAny()
                .orElse(NO_MATCH);
    }

    public static Rank findRank(long winnerMatch, boolean bonusMatch) {
        Rank rank = getInstance(winnerMatch);

        if (winnerMatch == FIVE_MATCH_NOT_BONUS.match) {
            if (bonusMatch) {
                return FIVE_MATCH_PLUS_BONUS;
            }
            return FIVE_MATCH_NOT_BONUS;
        }
        return rank;
    }
}

