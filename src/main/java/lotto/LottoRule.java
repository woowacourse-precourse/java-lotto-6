package lotto;

public enum LottoRule {
    NOTING(2, false),
    FIFTH_PRIZE(3, false),
    FOURTH_PRIZE(4, false),
    THIRD_PRIZE(5, false),
    SECOND_PRIZE(5, true),
    FIRST_PRIZE(6, false);

    private final int matchCount;
    private final boolean isBonusBall;
    LottoRule(int matchCount, boolean isBonusBall){
        this.matchCount = matchCount;
        this.isBonusBall = isBonusBall;
    }
    private static LottoResult checkSecondPrize(boolean isBonusBall){
        if( isBonusBall == SECOND_PRIZE.isBonusBall ){
            return LottoResult.SECOND_PRIZE;
        }
        return LottoResult.THIRD_PRIZE;
    }
    public static LottoResult of(int matchCount, boolean isBonusBall){
        if (matchCount <= NOTING.matchCount) {
            return LottoResult.NOTING;
        }
        if (matchCount == FIFTH_PRIZE.matchCount) {
            return LottoResult.FIFTH_PRIZE;
        }
        if (matchCount == FOURTH_PRIZE.matchCount) {
            return LottoResult.FOURTH_PRIZE;
        }
        if (matchCount == THIRD_PRIZE.matchCount) {
            return checkSecondPrize(isBonusBall);
        }
        return LottoResult.FIRST_PRIZE;
    }
    @Override
    public String toString(){
        String format = "%d개 일치";
        if( isBonusBall ){
            format += ", 보너스 볼 일치";
        }
        return String.format(format + " ", matchCount);
    }
}
