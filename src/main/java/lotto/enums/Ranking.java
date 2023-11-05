package lotto.enums;

public enum Ranking {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FORTH(50_000),
    FIFTH(5_000),
    BLANK(0);

    private final int prize;

    Ranking(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
