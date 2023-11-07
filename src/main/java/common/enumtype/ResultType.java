package common.enumtype;

public enum ResultType {

    NOT_WIN(2),
    FIFTH_PLACE(3),
    FOURTH_PLACE(4),
    THIRD_PLACE(5),
    SECOND_PLACE(5),
    FIRST_PLACE(6),
    ;

    private final int matchCount;

    ResultType(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static ResultType valueOf(int matchingCount, boolean isBonusMatching) {
        if (isFifthPlace(matchingCount, isBonusMatching)) {
            return FIFTH_PLACE;
        }
        if (isFourthPlace(matchingCount, isBonusMatching)) {
            return FOURTH_PLACE;
        }
        if (isThirdPlace(matchingCount, isBonusMatching)) {
            return THIRD_PLACE;
        }
        if (isSecondPlace(matchingCount, isBonusMatching)) {
            return SECOND_PLACE;
        }
        if (isFirstPlace(matchingCount)) {
            return FIRST_PLACE;
        }
        return NOT_WIN;
    }

    private static boolean isFifthPlace(int matchingCount, boolean isBonusMatching) {
        return (matchingCount == NOT_WIN.getMatchCount() && isBonusMatching)
                || (matchingCount == FIFTH_PLACE.getMatchCount() && !isBonusMatching);
    }

    private static boolean isFourthPlace(int matchingCount, boolean isBonusMatching) {
        return (matchingCount == FIFTH_PLACE.getMatchCount() && isBonusMatching)
                || (matchingCount == FOURTH_PLACE.getMatchCount() && !isBonusMatching);
    }

    private static boolean isThirdPlace(int matchingCount, boolean isBonusMatching) {
        return (matchingCount == FOURTH_PLACE.getMatchCount() && isBonusMatching)
                || (matchingCount == THIRD_PLACE.getMatchCount() && !isBonusMatching);
    }

    private static boolean isSecondPlace(int matchingCount, boolean isBonusMatching) {
        return matchingCount == SECOND_PLACE.getMatchCount() && isBonusMatching;
    }

    private static boolean isFirstPlace(int matchingCount) {
        return matchingCount == FIRST_PLACE.getMatchCount();
    }
}
