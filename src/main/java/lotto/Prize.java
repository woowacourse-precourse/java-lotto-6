package lotto;

public enum Prize {
    FIRST(6, 2_000_000_000, 4),
    SECOND(5, 30_000_000, 3),
    THIRD(5, 1_500_000, 2),
    FOURTH(4, 50_000, 1),
    FIFTH(3, 5_000, 0);

    private final int matchingNumbers;
    private final int prize;
    private final int index;

    Prize(int matchingNumbers, int prize, int index) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.index = index;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrize() {
        return prize;
    }

    public int getIndex() {
        return index;
    }
}
