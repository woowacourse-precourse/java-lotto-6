package lotto.domain;

public enum Result {

    FIFTH(3, 5000, 0, false),
    FORTH(4, 50000, 0, false),
    THIRD(5, 1500000, 0, false),
    SECOND(5, 30000000, 0, true),
    FIRST(6, 2000000000, 0, false);

    private int sameCount;
    private int money;
    private int resultCount;

    private boolean bonus;

    Result(int sameCount, int money, int resultCount, boolean isBonus) {
        this.sameCount = sameCount;
        this.money = money;
        this.resultCount = 0;
        this.bonus = isBonus;
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getMoney() {
        return money;
    }

    public int getResultCount() {
        return resultCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void addCount() {
        this.resultCount++;
    }

}
