package lotto.model.domain;

public enum Rank {

    FIRST(6,2000000000L,"2,000,000,000", false),
    SECOND_BONUS(5,30000000L,"30,000,000", true),
    THIRD(5,1500000L,"1,500,000", false),
    FOURTH(4,50000L,"50,000", false),
    FIFTH(3,5000L,"5,000", false);

    private final int count;
    private final long prize;
    private final String prizeForPrint;
    private final boolean isBonus;

    Rank(int count, long prize, String prizeForPrint, boolean isBonus) {
        this.count = count;
        this.prize = prize;
        this.prizeForPrint = prizeForPrint;
        this.isBonus = isBonus;
    }

    public static Rank lottoRank(int correctCount) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            if(rank.count == correctCount){
                return rank;
            }
        }
        throw new IllegalArgumentException("[ERROR] 맞는 숫자가 형식에 맞지 않습니다.");
    }


}
