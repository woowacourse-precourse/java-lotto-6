package lotto.model;

public enum WinningInfo {
    THREE_MATCH("3개 일치", 5000),
    FOUR_MATCH("4개 일치", 50000),
    FIVE_MATCH("5개 일치", 1500000),
    FIVE_AND_BONUS_MATCH("5개 일치, 보너스 볼 일치", 30000000),
    SIX_MATCH("6개 일치", 2000000000);

    public final String matchedCount;
    public final int price;

    WinningInfo(String matchedCount, int price){
        this.matchedCount = matchedCount;
        this.price = price;
    }

}
