package lotto.Enums;

public enum WinningRanks {
    FIRSTPROFIT(0, 2000000000), SECONDPROFIT(0, 30000000), THIRDPROFIT(0, 1500000), FOURTHPROFIT(0, 50000), FIFTHPROFIT(0, 5000);
    private long amount;
    private int count;

    WinningRanks(int count, long amount) {
        this.amount = amount;
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public long getAmount() {
        return amount;
    }
}
