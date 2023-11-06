package lotto.domain;

import java.util.Objects;
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
            System.out.println(LottoExceptionMessage.MUST_BE_POSITIVE_MULTIPLE.getMessage());
        }
        return null;
    }

    private void validate(int price) {
        isZero(price);
        isNegative(price);
        isNotMultiple(price);
    }

    private void isZero(int price) {
        if (price == 0) {
            throw new IllegalArgumentException(LottoExceptionMessage.MUST_BE_POSITIVE_MULTIPLE.getMessage());
        }
    }

    private void isNegative(int price) {
        if (price < 0) {
            throw new IllegalArgumentException(LottoExceptionMessage.MUST_BE_POSITIVE_MULTIPLE.getMessage());
        }
    }

    private void isNotMultiple(int price) {
        if (price % MULTIPLE != 0) {
            throw new IllegalArgumentException(LottoExceptionMessage.MUST_BE_POSITIVE_MULTIPLE.getMessage());
        }
    }
}
