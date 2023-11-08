package lotto.model.domain;

public enum Rank {
    FIRST(1, 2_000_000_000, 6, "6개 일치 (2,000,000,000원) - %d개\n"),
    SECOND(2, 30_000_000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    THIRD(3, 1_500_000, 5, "5개 일치 (1,500,000원) - %d개\n"),
    FOURTH(4, 50_000, 4, "4개 일치 (50,000원) - %d개\n"),
    FIFTH(5, 5_000, 3, "3개 일치 (5,000원) - %d개\n");

    private final int rank;
    private final long reward;
    private final long hitCount;
    private final String message;

    Rank(int rank, long reward, long hitCount, String message) {
        this.rank = rank;
        this.reward = reward;
        this.hitCount = hitCount;
        this.message = message;
    }

    public int getRank() {
        return rank;
    }

    public long getReward() {
        return reward;
    }

    public long getHitCount() {
        return hitCount;
    }

    public String getMessage() {
        return message;
    }
}
