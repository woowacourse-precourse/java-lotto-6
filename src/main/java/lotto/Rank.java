package lotto;

public enum Rank {
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    NONE(0, 0, "");

    private final int matchCnt;
    private final int money;
    private final String resultMessage;
    Rank(int matchCnt, int money, String resultMessage){
        this.matchCnt = matchCnt;
        this.money = money;
        this.resultMessage = resultMessage;
    }

    public static int getMatchCnt(Rank rank) {
        return rank.matchCnt;
    }

    public static int getMoney(Rank rank) {
        return rank.money;
    }

    public static String getResultMessage(Rank rank) {
        return rank.resultMessage;
    }
}
