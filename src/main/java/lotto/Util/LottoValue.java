package lotto.Util;

public enum LottoValue {
    // (일치하는 번호 개수, 등 수, 상금)
    FIRST_PLACE(6, 1, 200000000.0),
    SECOND_PLACE(5.5, 2, 30000000.0),
    THIRD_PLACE(5, 3, 1500000.0),
    FOURTH_PLACE(4, 4, 50000.0),
    FIFTH_PLACE(3, 5, 5000.0),
    NONE(0, 0, 0.0);
    private final double numberOfMatch;
    private final int rank;
    private final double reward;

    LottoValue(double numberOfMatch, int rank, double reward) {
        this.numberOfMatch = numberOfMatch;
        this.rank = rank;
        this.reward = reward;
    }

    public double getNumberOfMatch() {
        return numberOfMatch;
    }

    public int getRank() {
        return rank;
    }

    public double getReward() {
        return reward;
    }
}
