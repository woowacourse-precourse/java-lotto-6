package lotto.entity;

public enum Price {
    CORRECTION_3(5_000),
    CORRECTION_4(50_000),
    CORRECTION_5(1_500_000),
    CORRECTION_5_BONUS(30_000_000),
    CORRECTION_6(2_000_000_000);

    private Integer price;

    Price(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
