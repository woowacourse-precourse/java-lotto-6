package lotto.constant;

public enum LottoPrice {
    ONE_TICKET_PRICE(1000);

    private final int price;

    LottoPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}