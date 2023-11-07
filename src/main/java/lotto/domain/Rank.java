package lotto.domain;

public enum Rank {
    FirstRank(2000000000),
    SecondRank(30000000),
    ThirdRank(1500000),
    ForthRank(50000),
    FifthRank(5000),
    None(0);

    int prize;

    private Rank(int prize) {
        this.prize = prize;
    }

    public static Rank generateRank(int symbolNumber) {
        if(symbolNumber == 60) return FirstRank;
        if(symbolNumber == 51) return SecondRank;
        if(symbolNumber == 50) return ThirdRank;
        if(symbolNumber == 40) return ForthRank;
        if(symbolNumber == 30) return FifthRank;
        return None;
    }

    public int getPrize() {
        return prize;
    }
}
