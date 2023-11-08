package lotto.domain;

import java.util.HashMap;

public enum PrizeRank {

    Rank_1(1, 2000000000),
    Rank_2(2, 30000000),
    Rank_3(3, 1500000),
    Rank_4(4, 50000),
    Rank_5(5, 5000);

    private final int rank;

    private final int prizeMoney;

    PrizeRank(int rank, int prizeMoney) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
    }

    public int getRank() {
        return rank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static int getPrizeMoney(int rank){
        for(PrizeRank prizeRank : PrizeRank.values()){
            if(prizeRank.getRank() == rank){
                return prizeRank.getPrizeMoney();
            }
        }
        return 0;
    }
}
