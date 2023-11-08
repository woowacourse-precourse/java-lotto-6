package lotto.domain;

public class RankInfo {
    private final Rank rank;
    private int count;
    private long prize;

    public RankInfo(Rank rank, int count, long prize) {
        this.rank = rank;
        this.count = count;
        this.prize = prize;
    }

    public void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void addPrize(long prize) {
        this.prize += prize;
    }

    public Rank getRank() {
        return rank;
    }

    public long getPrize() {
        return prize;
    }

    public String getPrizeByWon() {
        return String.format("%,d", prize);
    }
}
