package lotto.domain;

public enum Winning {

    FIRST("6개 일치", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD("5개 일치", 1_500_000),
    FOURTH("4개 일치", 50_000),
    FIFTH("3개 일치", 5_000),
    FAIL("", 0);

    private final String status;
    private final int reward;

    Winning(final String status, final int reward) {
        this.status = status;
        this.reward = reward;
    }

    public String getStatus() {
        return status;
    }

    public int getReward() {
        return reward;
    }
}