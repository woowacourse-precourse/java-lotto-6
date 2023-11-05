package lotto.model;

public class Rank {
    private int rank;
    private long amount;
    private int count;
    private int matchingCount;

    public Rank(int rank, long amount, int count, int matchingCount) {
        this.rank = rank;
        this.amount = amount;
        this.count = count;
        this.matchingCount = matchingCount;
    }

    public int getRank() {
        return rank;
    }

    public long getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
