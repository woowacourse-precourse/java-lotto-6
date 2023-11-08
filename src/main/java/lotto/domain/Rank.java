package lotto.domain;

import java.util.Arrays;

/* 랭킹 enum
 *  */
public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000), // bonus
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0); // 일치하는 번호가 없거나 기준에 미달할 때


    private final int matchCount;
    private final int prize;

    Rank(final int matchCount, final int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
    public int getPrize() {
        return prize;
    }

    public static Rank getMatchRank(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public static Rank isSecondMatch(int matchCount, boolean isBonus) {
        // matchcount: 5면서, isBonus:true인건 SECOND로 return
        if (matchCount == 5 && isBonus) {
            return SECOND;
        }
        return getMatchRank(matchCount);
    }
}