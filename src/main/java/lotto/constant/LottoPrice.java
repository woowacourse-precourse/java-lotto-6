package lotto.constant;

public enum LottoPrice {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(50, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int number;
    private final int price;

    LottoPrice(int number, int price) {
        this.number = number;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

}
