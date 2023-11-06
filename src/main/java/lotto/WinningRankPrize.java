package lotto;

public enum WinningRankPrize {

    FIFTH("3개 일치", "5,000원"),
    FOURTH("4개 일치", "50,000원"),
    THIRD("5개 일치", "1,500,000원"),
    SECOND("5개 일치, 보너스 볼 일치", "30,000,000원"),
    FIRST("6개 일치", "2,000,000,000원");


    private String matchCount;
    private String prizeAmount;

    WinningRankPrize(String matchCount, String prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

}
