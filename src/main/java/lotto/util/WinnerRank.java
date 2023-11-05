package lotto.util;

public enum WinnerRank {
    THREE(3),
    FOUR(4),
    FIVE_WITHOUT_BOUNUS(5),
    SIX(6),
    FIVE_WITH_BONUS(7);

    int value;

    private WinnerRank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
