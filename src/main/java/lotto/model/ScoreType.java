package lotto.model;

public enum ScoreType {
    FIRST(1, 2000000000, 0),
    SECOND(2,30000000, 0),
    THIRD(3, 1500000, 0),
    FOURTH(4, 50000, 0),
    FIFTH(5, 5000, 0),
    NOTHING(6, 0, 0);

    private Integer ranking;
    private Integer money;
    private Integer count;
    ScoreType(int ranking, int money, int count) {
        this.ranking = ranking;
        this.money = money;
        this.count = count;
    }

    public Integer getMoney() {
        return money;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount() {
        this.count += 1;
    }
}
