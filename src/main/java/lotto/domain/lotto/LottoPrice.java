package lotto.domain.lotto;

public enum LottoPrice {
    THOUSAND_WON(1_000);

    private final int price;

    LottoPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
