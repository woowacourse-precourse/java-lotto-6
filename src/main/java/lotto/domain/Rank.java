package lotto.domain;


// 로또 당첨 순위를 정의하는 Enum
public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean isBonus;
    private final int prize;

    Rank(int matchCount, boolean isBonus, int prize) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.prize = prize;
    }


    public static Rank getRank(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return Rank.FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return Rank.SECOND;
        }
        if (matchCount == 5) {
            return Rank.THIRD;
        }
        if (matchCount == 4) {
            return Rank.FOURTH;
        }
        if (matchCount == 3) {
            return Rank.FIFTH;
        }
        return Rank.MISS;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
