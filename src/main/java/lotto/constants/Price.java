package lotto.constants;

public enum Price {

    RANK_1(2_000_000_000),
    RANK_2(30_000_000),
    RANK_3(1_500_000),
    RANK_4(50_000),
    RANK_5(5_000);

    private final int price;

    Price(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
