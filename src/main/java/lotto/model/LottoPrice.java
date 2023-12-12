package lotto.model;

public enum LottoPrice {
    ThreeMatch(5000),
    FourMatch(50000),
    FiveMatch(1500000),
    BonusMatch(30000000),
    SixMatch(2000000000);
    private final Integer price;
    LottoPrice(Integer price){
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
