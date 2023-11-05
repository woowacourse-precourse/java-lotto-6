package lotto.constant;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 1, 30000000, ", 보너스 볼 일치"),
    THIRD(5, 0, 1500000, ""),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int winningHit;
    private final int bonusHit;
    private final int reward;
    private final String message;


    Prize(int winningHit, int bonusHit, int reward, String message) {
        this.winningHit = winningHit;
        this.bonusHit = bonusHit;
        this.reward = reward;
        this.message = message;
    }

    Prize(int winningHit, int reward) {
        this(winningHit, 0, reward, "");
    }

    public int getWinningHit() {
        return winningHit;
    }

    public int getBonusHit() {
        return bonusHit;
    }

    public int getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }
}
