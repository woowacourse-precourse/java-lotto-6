package lotto.element;

public enum WinningDetails {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    BONUS( 5, 3_000_000),
    SIX(6, 2_000_000_000);

    private final int matchingNumbers;
    private final int prize;

    WinningDetails(int matchingNumbers, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }

    @Override
    public String toString() {
        return matchingNumbers + "개 일치 (" + prize + ") ";
    }
}
