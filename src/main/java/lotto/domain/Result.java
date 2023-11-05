package lotto.domain;

public enum Result {

    FIFTH(3, 5000, 0),
    FORTH(4, 50000, 0),
    THIRD(5,1500000, 0),
    SECOND(5, 30000000, 0),
    FIRST(6, 2000000000, 0);

    private int sameCount;

    private int money;
    private int resultCount;


    Result(int sameCount, int money, int resultCount) {
        this.sameCount = sameCount;
        this.money = money;
        this.resultCount = 0;
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

    public void addCount(){
        this.resultCount++;
    }

}
