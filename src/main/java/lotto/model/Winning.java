package lotto.model;


public enum Winning {
    THIRD(5, 3,"3개 일치", 5_000),
    FORTH(4, 4, "4개 일치",50_000),
    FIFTH(3, 5, "5개 일치",1_500_000),
    BONUS(2, 5, "5개 일치, 보너스 볼 일치",30_000_000),
    SIX(1, 6, "6개 일치", 2_000_000_000),
    ;

    private final Integer rank;
    private final Integer needCorrectNumber;
    private final String description;
    private final Integer prize;

    Winning(Integer rank, Integer needCorrectNumber, String description, Integer prize){
        this.rank = rank;
        this.needCorrectNumber = needCorrectNumber;
        this.description = description;
        this.prize = prize;
    }

    public Integer getRank() {
        return rank;
    }

    public Integer getNeedCorrectNumber(){
        return needCorrectNumber;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrize() {
        return prize;
    }
}
