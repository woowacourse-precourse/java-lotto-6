package lotto;

public enum Rank {

    FIRST(6, "2,000,000,000"),
    SECOND(5, "30,000,000"),
    THIRD(5, "1,500,000"),
    FOURTH(4, "50,000"),
    FIFTH(3, "5,000"),
    MISS(0,"0");

    private Integer ranking;
    private String money;

    Rank(Integer ranking, String money) {
        this.ranking = ranking;
        this.money = money;
    }

    public Integer getRanking() {
        return ranking;
    }

    public String getMoney() {
        return money;
    }
}
