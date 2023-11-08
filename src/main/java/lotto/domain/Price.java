package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoValue;

import java.math.BigInteger;

/**
 * 로또 구입 가격 값 담고 있는 클래스
 */
public class Price {
    private int price;

    public Price() {

    }

    public Price(String price) {
        validateNumber(price);
        int priceInt = Integer.parseInt(price);
        validatePrice(priceInt);

        this.price = priceInt;
    }

    public Price(int price) {
        validatePrice(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    private void validateNumber(String price) {
        price = price.trim();

        if (price.isBlank() || price == null) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_VALUE.getMessage());
        }
        if (isNotNumber(price)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private void validatePrice(int price) {
        if (price > LottoValue.MAXIMUM_PURCHASE_PRICE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.OVER_MAXIMUM_PRICE.getMessage());
        }
        if (price < LottoValue.PRICE_PER_PIECE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.UNDER_MINIMUM_PRICE.getMessage());
        }
        if (0 != (price % LottoValue.PRICE_PER_PIECE.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INDIVISIBLE_PRICE.getMessage());
        }
    }

    private boolean isNotNumber(String str) {
        try {
            BigInteger i = new BigInteger(str);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}
