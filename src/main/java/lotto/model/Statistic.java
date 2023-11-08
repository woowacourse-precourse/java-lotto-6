package lotto.model;

public class Statistic {
    private final Rank rank;
    private int count;

    public Statistic(Rank rank) {
        this.rank = rank;
        this.count = 0;
    }

    public void increaseCount() {
        this.count++;
    }

    public Rank getRank() {
        return rank;
    }

    public int getCount() {
        return count;
    }
}
