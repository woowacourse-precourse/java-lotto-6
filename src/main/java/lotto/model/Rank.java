package lotto.model;

public enum Rank {

    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    FIFTH_WITH_BONUS(7, 30000000),
    SIXTH(6, 2000000000);

    private final int score;
    private final int price;

    Rank(int score, int price){
        this.score = score;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public int getScore(){
        return score;
    }

}
