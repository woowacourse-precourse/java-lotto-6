package lotto.domain;

public enum Rank {
    MATCH_3(3, 5000, 1),
    MATCH_4(4, 50_000, 0),
    MATCH_5(5, 1_500_000, 0),
    MATCH_5_BONUS(5, 30_000_000, 0, true),
    MATCH_6(6, 2_000_000_000, 0);

    private final int countOfMatch;
    private final int prize;
    private final int countOfWin;
    private final boolean matchBonus;

    Rank(int countOfMatch, int prize, int countOfWin) {
        this(countOfMatch, prize, countOfWin, false);
    }

    Rank(int countOfMatch, int prize, int countOfWin, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
        this.countOfWin = countOfWin;
        this.matchBonus = matchBonus;
    }

    public static Rank calculateRank(int countOfMatch, boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.countOfMatch == countOfMatch && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return null;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrize() {
        return prize;
    }

    public int getCountOfWin() {
        return countOfWin;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}

