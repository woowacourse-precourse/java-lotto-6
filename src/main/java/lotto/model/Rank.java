package lotto.model;

public enum Rank {
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5000, "3 개 일치 (5,000원) - "),
    NONE(0, false, 0, "");

    private final int rank;
    private final boolean bonus;
    private final int prize;
    private final String resultMessage;

    Rank(int rank, boolean bonus, int prize, String resultMessage) {
        this.rank = rank;
        this.bonus = bonus;
        this.prize = prize;
        this.resultMessage = resultMessage;
    }

    public static Rank findWhichRank(int rank, boolean bonus) {
        if (rank == 6 & !bonus) {
            return FIRST;
        } else if (rank == 5 & bonus) {
            return SECOND;
        } else if (rank == 5 & !bonus) {
            return THIRD;
        } else if (rank == 4 & !bonus) {
            return FOURTH;
        } else if (rank == 3 & !bonus) {
            return FIFTH;
        } else if (rank < 3 & !bonus) {
            return NONE;
        }
        return null;
    }

    public int getRank() {
        return rank;
    }

    public boolean getBonus() {
        return bonus;
    }

    public int getPrize() {
        return prize;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
