package lotto.util;

public enum Rank {
    First(6, false, 2000000000,"6개 일치 (2,000,000,000원) - "),
    Second(5,true,30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    Third(5,false,1500000,"5개 일치 (1,500,000원) - "),
    Fourth(4,false,50000,"4개 일치 (50,000원) - "),
    Fifth(3,false,5000, "3개 일치 (5,000원) - "),
    Miss(0,false,0,"");

    private final int matchCount;
    private final boolean isMatchBonus;
    private final int prize;
    private final String resultMessage;

    Rank(int matchCount, boolean isMatchBonus, int prize, String resultMessage) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.prize = prize;
        this.resultMessage = resultMessage;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize(){
        return prize;
    }

    public String getResultMessage(){
        return resultMessage;
    }


}