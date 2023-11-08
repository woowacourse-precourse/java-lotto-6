package lotto.model.domain;

public enum Rank {

    FIRST(6,2000000000L,"2,000,000,000"),
    SECOND_BONUS(10,30000000L,"30,000,000"),
    THIRD(5,1500000L,"1,500,000"),
    FOURTH(4,50000L,"50,000"),
    FIFTH(3,5000L,"5,000"),
    NONE_TWO(2,0L,"0"),
    NONE_ONE(1,0L,"0"),
    NONE_ZERO(0,0L,"0");

    private final int identifyNum;
    private final long prize;
    private final String prizeForPrint;

    Rank(int identifyNum, long prize, String prizeForPrint) {
        this.identifyNum = identifyNum;
        this.prize = prize;
        this.prizeForPrint = prizeForPrint;
    }

    public static Rank lottoRank(int identifyNum) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            if(rank.identifyNum == identifyNum){
                return rank;
            }
        }
        throw new IllegalArgumentException("[ERROR] correctCount가 올바르지 않습니다.");
    }

    public long getPrize() {
        return prize;
    }

    public String getPrizeForPrint() {
        return prizeForPrint;
    }

}
