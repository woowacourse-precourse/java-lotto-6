package lotto.controller;

public enum Result {
    FIRST("6개 일치 (2,000,000,000원)", 1, 2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", -5, 30000000),
    THIRD("5개 일치 (1,500,000원)", 5, 1500000),
    FOURTH("4개 일치 (50,000원)", 4, 50000),
    FIFTH("3개 일치 (5,000원)", 3, 5000);

    private final String label;
    private final int correctCnt;
    private final int price;
    private int cnt;

    Result(String label, int correctCnt, int price) {
        this.label = label;
        this.correctCnt = correctCnt;
        this.price = price;
        this.cnt = 0;
    }

    public String label() {
        return label;
    }

    public int correctCnt() {
        return correctCnt;
    }

    public int cnt() {
        return cnt;
    }

    public void addCnt() {
        this.cnt++;
    }

    public int price() {
        return price;
    }
}
