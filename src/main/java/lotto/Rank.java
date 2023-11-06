package lotto;

public enum Rank {
    FIRST(6, 2000000000), SECOND(5, 30000000), THIRD(5, 1500000),
    FOURTH(4, 50000), FIFTH(3, 5000), LOSE(2, 0);

    private static final int MAXIMUM = 6;
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int MINIMUM = 3;

    private int sameCount;
    private int prize;

    Rank(int sameCount, int prize) {
        this.sameCount = sameCount;
        this.prize = prize;
    }

    public static Rank getRank(int sameCount, boolean sameBonusNumber) {
        if (sameCount == MAXIMUM) {
            return FIRST;
        }

        if (sameCount == FIVE && sameBonusNumber) {
            return SECOND;
        }

        if (sameCount == FIVE) {
            return THIRD;
        }

        if (sameCount == FOUR) {
            return FOURTH;
        }

        if (sameCount == MINIMUM) {
            return FIFTH;
        }

        return LOSE;
    }

}
