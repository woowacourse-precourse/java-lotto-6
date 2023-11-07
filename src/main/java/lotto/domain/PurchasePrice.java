package lotto.domain;

import java.util.Objects;
import lotto.exception.ErrorMessagePrinter;
import lotto.exception.LottoExceptionMessage;

public class PurchasePrice {
    private static final int MULTIPLE = 1000;
    private final int price;

    private PurchasePrice(int price) {
        validate(price);
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchasePrice that = (PurchasePrice) o;
        return price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    public static PurchasePrice from(int price) {
        try {
            return new PurchasePrice(price);
        } catch (IllegalArgumentException e) {
            ErrorMessagePrinter.printError(e);
        }
        return null;
    }

    public int getCount() {
        return price / MULTIPLE;
    }

    public int getPrice() {
        return price;
    }

    private void validate(int price) {
        isZero(price);
        isNegative(price);
        isNotMultiple(price);
    }

    private void isZero(int price) {
        if (price == 0) {
            throw new IllegalArgumentException(
                    LottoExceptionMessage.PURCHASE_PRICE_MUST_BE_POSITIVE_MULTIPLE.getMessage());
        }
    }

    private void isNegative(int price) {
        if (price < 0) {
            throw new IllegalArgumentException(
                    LottoExceptionMessage.PURCHASE_PRICE_MUST_BE_POSITIVE_MULTIPLE.getMessage());
        }
    }

    private void isNotMultiple(int price) {
        if (price % MULTIPLE != 0) {
            throw new IllegalArgumentException(
                    LottoExceptionMessage.PURCHASE_PRICE_MUST_BE_POSITIVE_MULTIPLE.getMessage());
        }
    }
}
