package lotto.model;

public class Price {
    private final int price;
    private static final int minPrice = 1000;

    public Price(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static void checkZeroPrice(int price) throws IllegalArgumentException{
        if (price < minPrice) {
            throw new IllegalArgumentException();
        }
    }


}
