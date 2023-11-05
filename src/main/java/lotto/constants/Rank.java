package lotto.constants;

public enum Rank {
    FIRST_PLACE_CONTDITION(6, false),
    SECOND_PLACE_CONTDITION(5, true),
    THIRD_PLACE_CONTDITION(5, false),
    FORTH_PLACE_CONTDITION(4, false),
    FIFTH_PLACE_CONTDITION(3, false);

    private final int numberOfMatchesRequired;
    private final boolean hasBonusNumber;

    Rank(int numberOfMatchesRequired, boolean hasBonusNumber) {
        this.numberOfMatchesRequired = numberOfMatchesRequired;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getNumberOfMatchesRequired() {
        return numberOfMatchesRequired;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }
}
