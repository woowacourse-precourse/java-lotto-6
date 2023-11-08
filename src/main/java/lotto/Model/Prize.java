package lotto.Model;

public enum Prize {
    FIFTH(5000),
    FOURTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000);


    private final Integer prize;

    Prize(Integer prize){
        this.prize = prize;
    }

    public int getPrize(){
        return prize;
    }
}
