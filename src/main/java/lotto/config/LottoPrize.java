package lotto.config;

public class LottoPrize {
    private int matchNumber;
    private int rank;
    private int reward;

    public LottoPrize(int rank, int matchNumber, int reward) {
        this.matchNumber = matchNumber;
        this.rank = rank;
        this.reward = reward;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getRank() {
        return rank;
    }

    public int getReward() {
        return reward;
    }
}
