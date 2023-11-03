package lotto.enums;

public enum Rank {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FORTH(50_000),
    FIFTH(5_000);

    final int prize;

    Rank(int prize) {
        this.prize = prize;
    }
}
