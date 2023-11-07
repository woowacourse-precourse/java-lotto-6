package lotto;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5.5f, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    LOSE(0, 0);

    private static final String RESULT_MESSAGE_FORMAT = "%d개 일치 (%,d원)";
    private static final String SECOND_PRIZE_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원)";
    private float matchCount;
    private int prize;
    Rank(float matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public boolean equals(float matchCount) {
        if (this == Rank.LOSE && matchCount < Rank.FIFTH.matchCount) {
            return true;
        }
        return this.matchCount == matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getResultMessage() {
        if (this == SECOND) {
            return String.format(SECOND_PRIZE_FORMAT, (int) matchCount, prize);
        }
        return String.format(RESULT_MESSAGE_FORMAT, (int) matchCount, prize);
    }
}
