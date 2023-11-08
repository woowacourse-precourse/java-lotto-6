package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true), // 보너스 번호 일치를 구분하기 위한 추가 필드
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean matchBonus;

    Rank(int matchCount, int prizeMoney) {
        this(matchCount, prizeMoney, false);
    }

    Rank(int matchCount, int prizeMoney, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && (matchBonus == rank.matchBonus || !rank.matchBonus)) {
                return rank;
            }
        }
        return NONE;
    }
}
