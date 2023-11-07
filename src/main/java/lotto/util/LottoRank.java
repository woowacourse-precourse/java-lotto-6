package lotto.util;

public enum LottoRank {
    FIRST_PRIZE(1,2_000_000_000L,6),
    SECOND_PRIZE(2,30_000_000L,5),
    THIRD_PRIZE(3,1_500_000L,5),
    FOURTH_PRIZE(4,50_000L,4),
    FIFTH_PRIZE(5,5_000L,3),
    NO_PRIZE(0,0L,0);

    private final int rank;
    private final Long winningAmount;
    private final int matchCount;


    LottoRank(int rank, Long winningAmount, int matchCount) {
        this.rank = rank;
        this.winningAmount = winningAmount;
        this.matchCount = matchCount;
    }

    public static LottoRank calculateRank(int matchCount, boolean isBonusNumbersMatch){
        return switch (matchCount){
            case 3-> FIFTH_PRIZE;
            case 4-> FOURTH_PRIZE;
            case 5-> checkForBonusMatch(isBonusNumbersMatch);
            case 6-> FIRST_PRIZE;
            default -> NO_PRIZE;
        };
    }

    private static LottoRank checkForBonusMatch(boolean isBonusNumbersMatch){
        if(isBonusNumbersMatch){
            return SECOND_PRIZE;
        }
        return THIRD_PRIZE;
    }



    public int getRank() {
        return rank;
    }
    public Long getWinningAmount() {
        return winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
