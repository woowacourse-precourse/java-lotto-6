package common.enumtype;

import java.util.Arrays;

public enum ResultType {

    NOT_WIN(0, 0),
    FIFTH_PLACE(3, 5_000),
    FOURTH_PLACE(4, 50_000),
    THIRD_PLACE(5, 1_500_000),
    SECOND_PLACE(6, 30_000_000),
    FIRST_PLACE(6, 2_000_000_000),
    ;

    private final int matchCount;
    private final int reward;

    ResultType(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public static ResultType valueOf(int matchingCount, boolean isBonusMatching) {
        if (isBonusMatching && matchingCount == SECOND_PLACE.getMatchCount()) {
            return SECOND_PLACE;
        }

        return Arrays.stream(ResultType.values())
                .filter(resultType -> resultType != ResultType.SECOND_PLACE)
                .filter(resultType -> resultType.getMatchCount() == matchingCount)
                .findFirst()
                .orElse(NOT_WIN);
    }
}
