package lotto.Domain;

public enum Rank {
    NOTHING(0, 0, ""),
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int matchNumberCount;
    private final int prize;
    private final String printString;

    Rank(int matchNumberCount, int prize, String printString) {
        this.matchNumberCount = matchNumberCount;
        this.prize = prize;
        this.printString = printString;
    }

    public static Rank valueOf(int matchNumberCount, boolean matchBonusNumber) {
        if (matchNumberCount == SECOND.matchNumberCount && matchBonusNumber) {
            return SECOND;
        }
        for (Rank rank : values()) {
            if (rank != SECOND && rank.matchNumberCount == matchNumberCount) {
                return rank;
            }
        }
        return NOTHING;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getPrintString() {
        return this.printString;
    }
}
