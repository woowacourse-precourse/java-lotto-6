package lotto;

public enum Rank {
    FIFTH("3개 일치 (5,000원)", 5000, 0),
    FOURTH("4개 일치 (50,000원)", 50000, 0),
    THIRD("5개 일치 (1,500,000원)", 1500000, 0),
    FIRST("6개 일치 (2,000,000,000원)", 2000000000, 0),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000, 0);

    private String explanation;
    private int prize;
    private int count;

    Rank(String explanation, int prize, int count) {
        this.explanation = explanation;
        this.prize = prize;
        this.count = count;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    // count를 1 증가시키는 함수
    public void increaseCount() {
        count++;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
