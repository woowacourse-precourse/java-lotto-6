package lotto.model;

public class PurchasePrice {
    int price;

    public PurchasePrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int calculateNumberOfLottos() {
        final int PRICE_OF_ONE_LOTTO = 1000;
        return price / PRICE_OF_ONE_LOTTO;
    }

}
