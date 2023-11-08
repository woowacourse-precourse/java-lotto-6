package lotto.constant;

public enum WinningDataCategory {
    THREE_MATCH(0, 5000),
    FOUR_MATCH(1, 50000),
    FIVE_MATCH(2, 50000),
    BONUS_MATCH(3, 30000000),
    SIX_MATCH(4, 2000000000);

    private final int position;
    private final int prize;

    WinningDataCategory(final int position, final int prize) {
        this.position = position;
        this.prize = prize;
    }

    public int getPosition() {
        return this.position;
    }

    public int getPrize() {
        return this.prize;
    }
}
