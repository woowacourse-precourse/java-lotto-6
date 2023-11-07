package lotto.element;

public enum WinningDetails {
    THREE(0, 3, 5_000),
    FOUR(1, 4, 50_000),
    FIVE(2, 5, 1_500_000),
    BONUS(3, 5, 3_000_000),
    SIX(4, 6, 2_000_000_000);

    int index;
    int matchingNumbers;
    int prize;

    WinningDetails(int index, int matchingNumbers, int prize) {
        this.index = index;
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }
}
