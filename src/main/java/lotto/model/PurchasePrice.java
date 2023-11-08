package lotto.model;

public class PurchasePrice {
    private static final int ONE_LOTTO_PRICE = 1000;
    private int price;

    public PurchasePrice(String price) throws IllegalArgumentException {
            validateNumber(price);
            validateCondition(price);
            this.price = Integer.parseInt(price);
    }

    private void validateNumber(String price) throws NumberFormatException {
        int amount;
        try {
            amount = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ONLY_NUMBER.getMessage());
        }
    }

    private void validateCondition(String price) throws IllegalArgumentException {
        int amount = Integer.parseInt(price);
        if (amount % ONE_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.CANT_DIVIDE_1000.getMessage());
        }
    }

    public int getPrice() {
        return price;
    }

    public int countPurchasedLottos() {
        return price/ONE_LOTTO_PRICE;
    }
}
