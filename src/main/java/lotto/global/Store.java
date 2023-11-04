package lotto.global;

public class Store {
    private static final int LOTTO_PRICE_UNIT = 1000;

    public static int convertPriceToCount(int price) {
        return price / LOTTO_PRICE_UNIT;
    }
}
