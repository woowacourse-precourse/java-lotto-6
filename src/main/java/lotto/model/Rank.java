package lotto.model;

public enum Rank {
    MATCH_3("3개 일치", 5_000),
    MATCH_4("4개 일치", 50_000),
    MATCH_5("5개 일치", 1_500_000),
    MATCH_5_BONUS("5개 일치, 보너스 볼 일치", 30_000_000),
    MATCH_6("6개 일치", 2_000_000_000);

    private final String description;
    private final int prize;

    Rank(String description, int prize) {
        this.description = description;
        this.prize = prize;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }
}
