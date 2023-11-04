package lotto;

public enum Rank {
    THREE("3개", 5000),
    FOUR("4개", 50000),
    FIVE("5개", 1500000),
    BONUS("보너스", 30000000),
    SIX("6개", 2000000000);

    private final String message;

    private final int prizeMoney;

    Rank(String message, int prizeMoney) {
        this.message = message;
        this.prizeMoney = prizeMoney;
    }
}
