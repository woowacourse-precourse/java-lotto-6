package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000L, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1_500_000L, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50_000L, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5_000L, "3개 일치 (5,000원) - "),
    NONE(0, false, 0L, "");

    private int matchOfCount;
    private boolean matchOfBonus;
    private long prize;
    private String message;

    Rank(int matchOfCount, boolean mathOfBonus, long prize, String message) {
        this.matchOfCount = matchOfCount;
        this.matchOfBonus = mathOfBonus;
        this.prize = prize;
        this.message = message;
    }

    public static Rank of(int matchOfCount, boolean matchOfBonus){
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(matchOfCount, matchOfBonus))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatch(int matchOfCount, boolean matchOfBonus){
        return this.matchOfCount == matchOfCount && this.matchOfBonus == matchOfBonus;
    }

    public int getMatchOfCount() {
        return matchOfCount;
    }

    public boolean isMatchOfBonus() {
        return matchOfBonus;
    }

    public long getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
