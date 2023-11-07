package lotto;

public class InputProcessor {
    public static int parsePrice(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(CustomErrorMessage.NUMBER_FORMAT);
        }
    }

    public static void checkPriceValidation(int price) {
        if (price < 0) {
            throw new IllegalArgumentException(CustomErrorMessage.PRICE_VALID);
        }
    }
}
