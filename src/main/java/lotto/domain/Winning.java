package lotto.domain;

public enum Winning {
    NO_WINNING(0, "0원"),
    THREE(5_000, "5,000원"),
    FOUR(50_000, "50,000원"),
    FIVE(1_500_000, "1,500,000원"),
    FIVE_BONUS(30_000_000, "30,000,000원"),
    SIX(2_000_000_000, "2,000,000,000원");

    private final int winningReward;
    private final String winningRewardDescription;

    Winning(int winningReward, String winningRewardDescription) {
        this.winningReward = winningReward;
        this.winningRewardDescription = winningRewardDescription;
    }

    public int getWinningReward() {
        return winningReward;
    }

    public int getWinningRewardDescription() {
        return winningReward;
    }

    public boolean isThree() {
        return this == THREE;
    }

    public boolean isFour() {
        return this == FOUR;
    }

    public boolean isFive() {
        return this == FIVE;
    }

    public boolean isFiveBonus() {
        return this == FIVE_BONUS;
    }

    public boolean isSix() {
        return this == SIX;
    }
}
