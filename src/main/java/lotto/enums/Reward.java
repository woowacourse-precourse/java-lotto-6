package lotto.enums;

public enum Reward {
    HIT_3(3, 0, 5000L),
    HIT_4(4, 0, 50000L),
    HIT_5(5, 0, 1500000L),
    HIT_5_AND_BONUS(5, 1, 30000000L),
    HIT_6(6, 0, 2000000000L);

    private final int hitCnt;
    private final int bonusCnt;
    private final long reward;

    Reward(int hitCnt, int isBonusHit, long reward) {
        this.hitCnt = hitCnt;
        this.bonusCnt = isBonusHit;
        this.reward = reward;
    }

    public int getHitCnt() {
        return hitCnt;
    }

    public int getBonusCnt() {
        return bonusCnt;
    }

    public long getReward() {
        return reward;
    }

    public boolean compareHitCnt(int hitResult) {
        return hitResult == hitCnt;
    }

    public boolean compareBonusCnt(int bonusResult) {
        return bonusResult == bonusCnt;
    }
}
