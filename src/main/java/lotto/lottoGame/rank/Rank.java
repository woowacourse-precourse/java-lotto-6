package lotto.lottoGame.rank;

public enum Rank {
    FIRST(6, 2000000000L),
    SECOND(5, 30000000L, true),  // 보너스 번호 확인 필요
    THIRD(5, 1500000L),
    FOURTH(4, 50000L),
    FIFTH(3, 5000L),
    BLANK(0, 0L);

    private final long matchingNumbers;
    private final long prize;
    private final boolean hasBonus;

    Rank(int matchingNumbers, long prize) {
        this(matchingNumbers, prize, false);
    }

    Rank(int matchingNumbers, long prize, boolean hasBonus) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    public static Rank getRankByMatchData(int matchingNumbers, boolean hasBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.isMatch(matchingNumbers, hasBonus)) {
                return rank;
            }
        }
        return Rank.BLANK;
    }

    private boolean isMatch(int matchingNumbers, boolean bonusMatch) {
        return this.matchingNumbers == matchingNumbers && this.hasBonus == bonusMatch;
    }

    public long getPrize() {
        return prize;
    }
}