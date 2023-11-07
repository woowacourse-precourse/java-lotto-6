package lotto.model;

public enum WinnerPrize {

    THREE_CORRECT(5000),
    FOUR_CORRECT(50000),
    FIVE_CORRECT(1500000),
    FIVE_ONE_CORRECT(30000000),
    SIX_CORRECT(2000000000);

    private final int prize;

    WinnerPrize(int prize) {
        this.prize = prize;
    }
}
