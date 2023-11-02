package lotto.domain;

public class PurchasePrice {

    private static final String priceRegex = "^[0-9]+(,*\\d)*$";
    private final int price;

    public PurchasePrice(String purchasePrice) {
        validate(purchasePrice);
        this.price = Integer.parseInt(purchasePrice);
    }

    public int getPrice() {
        return price;
    }

    private void validate(String purchasePrice) {
        validateFormat(purchasePrice);

        int numberOfPrice = parsePrice(purchasePrice);
        validateNotBelowOptimalPrice(numberOfPrice);
        validateDivisibleByProperAmount(numberOfPrice);
    }

    private int parsePrice(String purchasePrice) {
        return Integer.parseInt(purchasePrice.replaceAll(",", ""));
    }

    private void validateFormat(String purchasePrice) {
        if (!purchasePrice.matches(priceRegex)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotBelowOptimalPrice(int numberOfPrice) {
        if (numberOfPrice < 1000) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivisibleByProperAmount(int numberOfPrice) {
        if (numberOfPrice % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
