package domain;

public enum Rank {
    FIFTH(3, false, 5_000),

    FOURTH(4, false, 50_000),

    THIRD(5, false, 1_500_000),

    SECOND(5, true, 30_000_000),

    FIRST(6, false, 2_000_000_000);

    private static final String RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_RANK_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    private final int winningNumberCount;
    private final boolean hasBonusNumber;
    private final int prize;


    Rank(int winningNumberCount, boolean hasBonusNumber, int prize) {
        this.winningNumberCount = winningNumberCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static Rank getRank(int winningNumberCount, boolean hasBonusNumber) {
        for (Rank rank : Rank.values()) {
            if (rank.winningNumberCount == winningNumberCount && rank.hasBonusNumber == hasBonusNumber) {
                return rank;
            }
        }

        for (Rank rank : Rank.values()) {
            if (rank.winningNumberCount == winningNumberCount) {
                return rank;
            }
        }

        return null;
    }


    public int getWinningNumberCount() {
        return winningNumberCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessageFormat() {
        if (this == SECOND) {
            return SECOND_RANK_RESULT_MESSAGE;
        }

        return RESULT_MESSAGE;
    }
}
