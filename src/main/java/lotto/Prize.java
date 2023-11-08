package lotto;

public enum Prize {
    THREE_PRIZE(3, 5000, "3개 일치 (5,000원) - "),
    FOUR_PRIZE(4, 50000, "4개 일치 (50,000원) - "),
    FIVE_PRIZE(5, 1500000, "5개 일치 (1,500,000원) - "),
    FIVE_PRIZE_BONUS(6, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_PRIZE(7, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private static final String suffix = "개";
    private final int rank;
    private final int prize;
    private final String message;

    Prize(int rank, int prize, String message) {
        this.rank = rank;
        this.prize = prize;
        this.message = message;
    }

    public long getPrize() {
        return this.prize;
    }

    public String getMessage(int count) {
        return message + count + suffix;
    }
}
