package lotto;

public enum Rank {

    RANK_1(2_000_000_000),
    RANK_2(30_000_000),
    RANK_3(1_500_000),
    RANK_4(50_000),
    RANK_5(5_000),
    RANK_NONE(0);

    private int price;

    Rank(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
