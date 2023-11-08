package lotto.domain.constants;

public enum LottoStatisticsContent {
    MISS(0, 0, ""),
    FIFTH(3, 5000,
            "3개 일치 (5,000원) - "),
    FOURTH(4, 50000,
            "4개 일치 (50,000원) - "),
    THIRD(5, 1500000,
            "5개 일치 (1,500,000원) - "),
    SECOND(5, 30000000,
            "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2000000000,
            "6개 일치 (2,000,000,000원) - ");

    private final int hitCount;
    private final int prize;
    private int prizeCount;
    private final String message;

    LottoStatisticsContent(int hitCount, int prize, String message) {
        this.hitCount = hitCount;
        this.prize = prize;
        this.message = message;
    }

    public static LottoStatisticsContent matchHitCount(long hitCount, boolean bonusMatch) {
        if (hitCount == FIRST.hitCount) {
            return FIRST;
        }
        if (hitCount == SECOND.hitCount && bonusMatch) {
            return SECOND;
        }
        if (hitCount == THIRD.hitCount) {
            return THIRD;
        }
        if (hitCount == FOURTH.hitCount) {
            return FOURTH;
        }
        if (hitCount == FIFTH.hitCount) {
            return FIFTH;
        }
        return MISS;
    }

    public void increasePrizeCount() {
        this.prizeCount++;
    }

    public String getMessage() {
        return this.message;
    }

    public int getPrizeCount() {
        return this.prizeCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getHitCount() {
        return this.hitCount;
    }
}
