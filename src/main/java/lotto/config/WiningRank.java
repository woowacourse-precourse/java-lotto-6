package lotto.config;

public enum WiningRank {
    RANK1(2000000000),
    RANK2(30000000),
    RANK3(1500000),
    RANK4(50000),
    RANK5(5000),
    NOTHING(0);

    private int price;

    WiningRank(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
