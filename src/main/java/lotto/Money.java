package lotto;

public class Money {

    private final int price;
    private final int priceUnit = 1_000;

    public Money(int price) {
        vaildateNegativeRange(price);
        vaildateLowRange(price);
        vaildateRemain(price);
        this.price = price;
    }

    private void vaildateNegativeRange(int price) {
        if (price < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void vaildateLowRange(int price) {
        if (0 <= price && price < priceUnit) {
            throw new IllegalArgumentException();
        }
    }

    private void vaildateRemain(int price) {
        if (price % priceUnit == 0) {
            throw new IllegalArgumentException();
        }
    }

    public int calculateLottoSize() {
        return price / priceUnit;
    }
}
