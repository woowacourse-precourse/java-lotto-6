package lotto;

public enum Result {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);


    private final int matchCount;

    private final int winningMoney;

    private final boolean isBonus;

    Result(int matchCount, int winningMoney, boolean isBonus) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.isBonus = isBonus;
    }

    public static Result valueOf(int matchCount, boolean isBonus) {
        if (matchCount == 5 && isBonus) {
            return SECOND;
        }
        for (Result result : Result.values()) {
            if (result.matchCount == matchCount) {
                return result;
            }
        }
        return MISS;
    }
}
