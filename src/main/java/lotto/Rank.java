package lotto;

public enum Rank {
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50000),
    FIVE_MATCH(5, false, 1500000),
    FIVE_MATCH_AND_BONUS(5, true, 30000000),
    SIX_MATCH(6, false, 2000000000);

    private final int counted;
    private final boolean checked;
    private final int prize;

    Rank(int counted, boolean checked, int prize) {
        this.counted = counted;
        this.checked = checked;
        this.prize = prize;
    }

    public int getCounted() {
        return counted;
    }

    public boolean getChecked() {
        return checked;
    }

    public int getPrize() {
        return prize;
    }
}