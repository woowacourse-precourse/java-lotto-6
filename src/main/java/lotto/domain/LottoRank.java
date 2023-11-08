package lotto.domain;

public enum LottoRank {
    FIRST(6, 2_000_000_000), SECOND(5, 30_000_000), // with bonus number
    THIRD(5, 1_500_000), FOURTH(4, 50_000), FIFTH(3, 5_000), NONE(0, 0);

    private final int matchingNumbers;
    private final int prize;

    LottoRank(int matchingNumbers, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == SECOND.matchingNumbers && matchBonus) {
            return SECOND;
        }

        for (LottoRank rank : values()) {
            if (rank.getMatchingNumbers() == matchCount && rank != SECOND) {
                return rank;
            }
        }
        return NONE;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrize() {
        return prize;
    }
}
