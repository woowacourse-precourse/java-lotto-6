package lotto.model;

import lotto.message.ErrorMessage;

import java.util.regex.Pattern;

public class Price {
    private static final String REGEX = "[0-9]+";
    private final static int LOTTO_PRICE = 1_000;

    private final int price;

    public Price(String purchasePrice) {
        isNumber(purchasePrice);
        this.price = Integer.parseInt(purchasePrice);
        isPossiblePrice(price);
    }

    public int getPrice() {
        return price;
    }

    public int getPossibleLotto() {
        return price / LOTTO_PRICE;
    }

    private void isNumber(String purchasePrice) {
        if (!Pattern.matches(REGEX, purchasePrice)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_PRICE_NOT_NUMBER.getMessage());
        }
    }

    private void isPossiblePrice(int purchasePrice) {
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_PRICE_NOT_POSSIBLE.getMessage());
        }
    }
}
