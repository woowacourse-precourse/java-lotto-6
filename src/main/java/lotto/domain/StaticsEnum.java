package lotto.domain;

public enum StaticsEnum {
    MATCHED_MINIMUM(3, 0),
    MATCHED_THREE(3, 5000),
    MATCHED_FOUR(4, 50000),
    MATCHED_FIVE(5, 1500000),
    MATCHED_FIVE_WITH_BONUS(5, 30000000),
    MATCHED_SIX(6, 2000000000);

    private final int count;
    private final int prize;

    StaticsEnum(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public static StaticsEnum getStaticsEnum(long numberOfMatched, boolean hasBonusBall) {
        if (numberOfMatched == 3) {
            return MATCHED_THREE;
        }
        if (numberOfMatched == 4) {
            return MATCHED_FOUR;
        }
        if (numberOfMatched == 5 && !hasBonusBall) {
            return MATCHED_FIVE;
        }
        if (numberOfMatched == 5 && hasBonusBall) {
            return MATCHED_FIVE_WITH_BONUS;
        }
        if (numberOfMatched == 6) {
            return MATCHED_SIX;
        }
        return MATCHED_MINIMUM;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }
}
