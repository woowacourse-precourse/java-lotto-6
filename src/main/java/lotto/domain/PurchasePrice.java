package lotto.domain;

public class PurchasePrice {

    private static final String priceRegex = "^[0-9]+(,*\\d)*$";
    private final int price;

    public PurchasePrice(String purchasePrice) {
        validate(purchasePrice);
        this.price = Integer.parseInt(purchasePrice);
    }

    private void validate(String purchasePrice) {
        validateFormat(purchasePrice);
    }

    private void validateFormat(String purchasePrice) {
        if (!purchasePrice.matches(priceRegex)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBelow1000won(String purchasePrice) {
        int price = Integer.parseInt(purchasePrice.replaceAll(",", ""));
        if (price < 1000) {
            throw new IllegalArgumentException();
        }
    }
}
