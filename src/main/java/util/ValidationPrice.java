package util;

public class ValidationPrice {

    private ValidationPrice() {

    }

    public static void validatePrice(String price) {
        validateNumber(price);
    }

    public static void validateNumber(String priceString) {
        try {
            Integer price = Integer.parseInt(priceString);
        } catch (NumberFormatException notANumber) {
            throw new IllegalArgumentException(ValidationPriceMessages.NOT_A_NUMBER.getMessage());
        }
    }
}
