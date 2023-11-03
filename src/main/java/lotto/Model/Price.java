package lotto.Model;

public class Price {
    int price;

    public Price(int price) {
        this.price = price;
    }

    public int divideWithOneThousands() {
        return price / 1000;
    }

}
