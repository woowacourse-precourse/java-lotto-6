package lotto.domain;

public enum Rank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000),
    NONE(0);

    private Integer prize;

    Rank(Integer prize){
        this.prize = prize;
    }

    public Integer getPrize(){
        return prize;
    }
}
