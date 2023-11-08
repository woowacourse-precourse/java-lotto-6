package lotto;

public enum Rank {
    FIRST(6,2000000000),
    SECOND(5,30000000),
    THIRD(5,1500000),
    FOURTH(4,50000 ),
    FIFTH(3, 5000),
    NORANK(0,0);


    private int correctNumberCnt;
    private int rewardMoney;

    Rank(int correctNumberCnt, int rewardMoney){
        this.correctNumberCnt = correctNumberCnt;
        this.rewardMoney = rewardMoney;
    }


}
