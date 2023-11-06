package lotto.util;

public enum LottoRank {
    FIRST_PRIZE(1,2_000_000_000L),
    SECOND_PRIZE(2,30_000_000L),
    THIRD_PRIZE(3,1_500_000L),
    FOURTH_PRIZE(4,50_000L),
    FIFTH_PRIZE(5,5_000L),
    NO_PRIZE(0,0L);

    private final int rank;
    private final Long winningAmount;

    LottoRank(int rank, Long winningAmount) {
        this.rank = rank;
        this.winningAmount = winningAmount;
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

}
