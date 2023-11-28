package lotto.model;

import static lotto.constant.Constant.THOUSAND;
import static lotto.constant.Constant.ZERO;
import static lotto.exception.ErrorInputException.ErrorMessage.PURCHASE_PRICE_CAN_DIVIDE_BY_THOUSAND;

import lotto.exception.ErrorInputException;

public class PurchasePrice {
    private final int price;

    private PurchasePrice(int price) {
        isDividedByThousand();
        this.price = price;
    }

    public static PurchasePrice createPurchasePrice(int price) {
        return new PurchasePrice(price);
    }

    public int getPrice() {
        return price;
    }

    private void isDividedByThousand() {
        if (price % THOUSAND != ZERO) {
            throw new ErrorInputException(PURCHASE_PRICE_CAN_DIVIDE_BY_THOUSAND);
        }
    }

    public int calculateLottoCount() {
        return price / THOUSAND;
    }
}
