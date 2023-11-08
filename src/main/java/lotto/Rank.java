package lotto;

public enum Rank {
    FIFTH("30", "3개 일치", 5000, 0),
    FOURTH("40", "4개 일치", 50000, 0),
    THIRD("50", "5개 일치", 1500000, 0),
    SECOND("51", "5개 일치, 보너스 볼 일치", 30000000, 0),
    FIRST("60", "6개 일치", 2000000000, 0);

    private String matchResult;
    private String matchStandard;
    private int price;
    private int count;

    Rank(String matchResult, String matchStandard, int price, int count) {
        this.matchResult = matchResult;
        this.matchStandard = matchStandard;
        this.price = price;
        this.count = count;
    }

    public String getMatchResult() {
        return matchResult;
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
