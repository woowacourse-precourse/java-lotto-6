package lotto;

public enum Rank {
    FIFTH(5, "3개 일치", 5000, 0),
    FOURTH(4, "4개 일치", 50000, 0),
    THIRD(3, "5개 일치", 1500000, 0),
    SECOND(2, "5개 일치, 보너스 볼 일치", 30000000, 0),
    FIRST(1, "6개 일치", 2000000000, 0);

    private String matchStandard;
    private int price;
    private int count;

    Rank(int rank, String matchStandard, int price, int count) {
        this.matchStandard = matchStandard;
        this.price = price;
        this.count = 0;
    }

    public String getMatchStandard() {
        return matchStandard;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
