package lotto.model;


public enum Winning {
    THIRD(5, 3,"3개 일치", "5,000원"),
    FORTH(4, 4, "4개 일치","50,000원"),
    FIFTH(3, 5, "5개 일치","1,500,000원"),
    BONUS(2, 5, "5개 일치, 보너스 볼 일치","30,000,000원"),
    SIX(1, 6, "6개 일치", "2,000,000,000원"),
    ;

    private final Integer rank;
    private final Integer needCorrectNumber;
    private final String description;
    private final String price;

    Winning(Integer rank, Integer needCorrectNumber, String description, String price){
        this.rank = rank;
        this.needCorrectNumber = needCorrectNumber;
        this.description = description;
        this.price = price;
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

    public String getPrice() {
        return price;
    }
}
