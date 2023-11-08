package lotto.utils;

public enum WinningRank {
    FIFTH(3, 0, "5,000", 5000),
    FOURTH(4, 0, "50,000", 50000),
    THIRD(5, 0, "1,500,000", 1500000),
    SECOND(5,0, "30,000,000", 30000000),
    FIRST(6, 0, "2,000,000,000", 2000000000);

    private int match;
    private int count;
    private String price;
    private int reward;

    WinningRank(int match, int count, String price, int reward) {
        this.match = match;
        this.count = count;
        this.price = price;
        this.reward = reward;
    }

    public int getMatch() {
        return match;
    }

    public int getCount() {
        return count;
    }

    public String getPrice() {
        return price;
    }

    public int getReward() {
        return reward;
    }

    public void increaseRankCount() {
        this.count++;
    }
}
