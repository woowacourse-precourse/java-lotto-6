package lotto;

public enum RankConfig {
    FIRST_BALL(6),
    SECOND_BALL(5),
    THIRD_BALL(5),
    FOURTH_BALL(4),
    FIFTH_BALL(3),
    FIRST_PRIZE(2_000_000_000),
    SECOND_PRIZE(30_000_000),
    THIRD_PRIZE(1_500_000),
    FOURTH_PRIZE(50_000),
    FIFTH_PRIZE(5_000);

    private final Integer rankConfig;

    RankConfig(Integer rankConfig) {
        this.rankConfig = rankConfig;
    }

    public Integer get() {
        return rankConfig;
    }
}
