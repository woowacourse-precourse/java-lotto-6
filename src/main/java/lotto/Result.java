package lotto;

public enum Result {
    FIFTH("3개 일치 (5,000원) - ", 5000, 6),
    FOURTH("4개 일치 (50,000원) - ", 50000,8),
    THIRD("5개 일치 (1,500,000원) - ", 1500000,10),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000,11),
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000, 12);


    private final String result;
    private final long prizeMoney;
    private final int same;

    public String getResult() {
        return result;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getSame() {
        return same;
    }

    Result(String result, long prizeMoney, int same) {
        this.result = result;
        this.prizeMoney = prizeMoney;
        this.same = same;
    }
}
