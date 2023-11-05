package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    NO("0개 일치 - ",false,0,0),
    FIFTH("3개 일치 (5,000원) - ",false,3,5000),
    FOURTH("4개 일치 (50,000원) - ",false,4,50000),
    THIRD("5개 일치 (1,500,000원) - ",false,5,1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ",true,5,30000000),
    FIRST("6개 일치 (2,000,000,000원) - ",false,6,200000000);
    private final String message;
    private final boolean bonusCheck;
    private final int matchCount;
    private final int prize;

    Rank(final String message, final boolean bonusCheck, final int matchCount, final int prize) {
        this.message = message;
        this.bonusCheck = bonusCheck;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static List<Rank> getValidRanks(List<Rank> ranks) {
        return ranks.stream()
                .filter(rank -> rank != Rank.NO)
                .collect(Collectors.toList());
    }
    public int getCount(List<Rank> ranks) {
        return (int) ranks.stream()
                .filter(rank -> rank.matchCount == this.matchCount)
                .filter(rank -> rank.bonusCheck == this.bonusCheck)
                .count();
    }

    public String getMessage() {
        return message;
    }

    public boolean isBonusCheck() {
        return bonusCheck;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
