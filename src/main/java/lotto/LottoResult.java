package lotto;

public enum LottoResult {
    THREE("3개 일치", 5000),
    FOUR("4개 일치", 50000),
    FIVE("5개 일치", 1500000),
    FIVE_BONUS("5개 일치, 보너스 볼 일치", 30000000),
    SIX("6개 일치", 2000000000)
    ;

    private final String description;
    private final long prize;

    LottoResult(String description, long prize) {
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
