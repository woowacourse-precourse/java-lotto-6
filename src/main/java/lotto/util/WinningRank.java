package lotto.util;

public enum WinningRank {
    FIRST(0, 2000000000),
    SECOND(0, 30000000),
    THIRD(0, 1500000),
    FOURTH(0, 50000),
    FIFTH(0, 5000);


    private int count;
    private int price;

    WinningRank(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public void increaseRankCount() {
        this.count++;
    }
}
