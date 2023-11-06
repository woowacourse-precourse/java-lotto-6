package lotto.constants;

public enum Rank {
    FIRST_PLACE_CONDITION(1,6, 0,2000000000),
    SECOND_PLACE_CONDITION(2,5, 1,30000000),
    THIRD_PLACE_CONDITION(3,5, -1,1500000),
    FORTH_PLACE_CONDITION(4,4, 0,50000),
    FIFTH_PLACE_CONDITION(5,3, 0,5000);


    private final int index;
    private final int numberOfMatchesRequired;
    private final int hasBonusNumber;

    private final int prize;

    Rank(int index, int numberOfMatchesRequired, int hasBonusNumber, int prize) {
        this.index = index;
        this.numberOfMatchesRequired = numberOfMatchesRequired;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public int getNumberOfMatchesRequired() {
        return numberOfMatchesRequired;
    }

    public int getHasBonusNumber() {
        return hasBonusNumber;
    }

    public static int getIndexFromConditions(int numberOfMatchesRequired, int hasBonusNumber) {
        for (Rank type : Rank.values()) {
            if (type.getNumberOfMatchesRequired() == numberOfMatchesRequired
                    && type.getHasBonusNumber() == hasBonusNumber) {
                return type.index;
            }
        }
        return 0;
    }

    public static int getPrizeFromIndex(int index) {
        for (Rank type : Rank.values()) {
            if (type.index == index) {
                return type.prize;
            }
        }
        return 0;
    }

    public static int getNumberOfMatchesRequiredFromIndex(int index) {
        for (Rank type : Rank.values()) {
            if (type.index == index) {
                return type.numberOfMatchesRequired;
            }
        }
        return 0;
    }

    public static int getHasBonusNumberFromIndex(int index) {
        for (Rank type : Rank.values()) {
            if (type.index == index) {
                return type.hasBonusNumber;
            }
        }
        return 0;
    }
}
