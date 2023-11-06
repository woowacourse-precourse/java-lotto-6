package lotto.model;

public enum LottoPrize {

    FIRST_PRIZE("6개 일치 (2,000,000,000원) - ", 2_000_000_000),
    SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    THIRD_PRIZE("5개 일치 (1,500,000원) - ", 1_500_000),
    FOURTH_PRIZE("4개 일치 (50,000원) - ", 50_000),
    FIFTH_PRIZE("3개 일치 (5,000원) - ", 5_000),
    NO_PRIZE("당첨 안됨 (0원)", 0);

    private final String description;
    private final long prize;

    LottoPrize(final String description, final long prize) {
        this.description = description;
        this.prize = prize;
    }

    public String getDescription() {
        return description;
    }

    public long getPrize() {
        return prize;
    }
}
