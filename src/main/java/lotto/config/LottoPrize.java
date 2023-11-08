package lotto.config;

public class LottoPrize {
    private int matchNumber;

    private boolean bonus;
    private int rank;
    private int reward;

    public LottoPrize(int rank, int matchNumber,boolean bonus, int reward) {
        this.matchNumber = matchNumber;
        this.bonus = bonus;
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

    public boolean getBonus() {
        return bonus;
    }
}
