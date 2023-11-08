package lotto.enums;

public enum Rank {

    FIRST(1, 6, false)
    , SECOND(2, 5, true)
    , THIRD(3, 5, false)
    , FOURTH(4, 4, false)
    , FIFTH(5, 3, false)
    , OTHER(-1, 0, false);

    private static final Rank[] rankValues = Rank.values();
    private final int value;
    private final int correctCount;
    private final boolean isBonusCorrect;

    Rank(int value, int correctCount, boolean isBonusCorrect) {
        this.value = value;
        this.correctCount = correctCount;
        this.isBonusCorrect = isBonusCorrect;
    }

    public int getValue() {
        return value;
    }

    public int getCorrectCount() { return correctCount; }

    public boolean isBonusCorrect() { return isBonusCorrect; }

    public static Rank of(int value) {
        if (value == Rank.OTHER.getValue()) {
            return Rank.OTHER;
        }
        return rankValues[value - 1];
    }
}
