package lotto;

public enum Statistic {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FORTH(4, 50000),
    FIFTH(3, 5000);

    private final int matchingNumbers;
    private final int prize;

    Statistic(int matchingNumbers, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }
}
