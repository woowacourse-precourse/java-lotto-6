package lotto;

public enum Rank {

    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), OTHER(-1);

    private static final Rank[] rankValues = Rank.values();
    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Rank of(int value) {
        if (value == -1) {
            return Rank.OTHER;
        }
        return rankValues[value - 1];
    }
}
