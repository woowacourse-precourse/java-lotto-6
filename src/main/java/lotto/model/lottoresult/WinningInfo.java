package lotto.model.lottoresult;

public enum WinningInfo {
    THREE_MATCH("3개 일치", 5000),
    FOUR_MATCH("4개 일치", 50000),
    FIVE_MATCH("5개 일치", 1500000),
    FIVE_AND_BONUS_MATCH("5개 일치, 보너스 볼 일치", 30000000),
    SIX_MATCH("6개 일치", 2000000000),
    NONE("당첨되지 않음", 0);

    public final String matchedInfo;
    public final int price;

    WinningInfo(String matchedInfo, int price){
        this.matchedInfo = matchedInfo;
        this.price = price;
    }

    public static WinningInfo of(LottoResult lottoResult){
        int matchedCount = lottoResult.matchedCount;
        boolean isBonusMatched = lottoResult.isBonusMatched;

        if(matchedCount == 6) return SIX_MATCH;

        if(matchedCount == 5 && isBonusMatched) return FIVE_AND_BONUS_MATCH;

        if(matchedCount == 5) return FIVE_MATCH;

        if(matchedCount == 4) return FOUR_MATCH;

        if(matchedCount == 3) return THREE_MATCH;

        return NONE;
    }

}
