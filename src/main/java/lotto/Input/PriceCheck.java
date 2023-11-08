package lotto.Input;

public class PriceCheck {
    static final int PRICE = 1000;

    public static void validatePrice(String input) throws IllegalArgumentException {
        if (Integer.parseInt(input) % PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
