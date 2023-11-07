package lotto.core;

public enum DrawResult {

    FIRST_PRIZE(6, false, 2_000_000_000),
    SECOND_PRIZE(5, true, 30_000_000),
    THIRD_PRIZE(5, false, 1_500_000),
    FOURTH_PRIZE(4, false, 50_000),
    FIFTH_PRIZE(3, false, 5_000),
    NO_PRIZE(0, false, 0);

    private int hitCount;
    private boolean bonusHit;
    private long winnings;

    private DrawResult(int hitCount, boolean bonusHit, long winnings) {
        this.hitCount = hitCount;
        this.bonusHit = bonusHit;
        this.winnings = winnings;
    }

    public static DrawResult resultOf(int hitCount, boolean bonusHit) {
        if (hitCount == 6)
            return FIRST_PRIZE;
        else if (hitCount == 5 && bonusHit)
            return SECOND_PRIZE;
        else if (hitCount == 5 && !bonusHit)
            return THIRD_PRIZE;
        else if (hitCount == 4)
            return FOURTH_PRIZE;
        else if (hitCount == 3)
            return FIFTH_PRIZE;
        return NO_PRIZE;
    }

    public int getHitCount() {
        return hitCount;
    }

    public long getWinnings() {
        return this.winnings;
    }
}
