package lotto.domain;

public enum Prize {

    ZERO(0,"0개 일치 ",0),
    ONE(1,"1개 일치 ",0),
    TWO(2,"2개 일치 ",0),
    THREE(3,"3개 일치 ",5_000),
    FOUR(4, "4개 일치 ",50_000),
    FIVE(5, "5개 일치 ",1_500_000),
    FIVE_BONUS(5, "5개 일치, 보너스 볼 일치 ",30_000_000),
    SIX(6, "6개 일치 ",2_000_000_000);



    private final Integer matchCount;
    private final String prizeMessage;
    private final Integer winningAmount;

    Prize(Integer matchCount, String prizeMessage, Integer winningAmount) {
        this.matchCount = matchCount;
        this.prizeMessage = prizeMessage;
        this.winningAmount = winningAmount;
    }

    public static Prize getPrizeByMatchCount(int matchCount, boolean isBonusNumberMatch){
        Prize[] prizes = values();
        if (matchCount == 5){
            return isFiveOrFiveBonus(isBonusNumberMatch);
        }
        return prizes[matchCount];
    }

    public static Prize isFiveOrFiveBonus(boolean isBonusNumberMatch){
        if (isBonusNumberMatch){
            return FIVE_BONUS;
        }
        return FIVE;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getWinningAmount() {
        return winningAmount;
    }

    public String getPrizeMessage(){
        return prizeMessage;
    }
}
