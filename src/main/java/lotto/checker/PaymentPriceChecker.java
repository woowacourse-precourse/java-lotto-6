package lotto.checker;

import static lotto.constant.ExceptionMessage.REQUIRE_MULTIPLE_OF_LOTTO_PRICE;
import static lotto.constant.ExceptionMessage.REQUIRE_POSITIVE_LONG;

import lotto.constant.Number;
import lotto.view.OutputHandler;

public class PaymentPriceChecker {

    long paymentPrice;

    public PaymentPriceChecker(long paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public void positive() throws IllegalArgumentException {
        if (paymentPrice <= 0) {
            OutputHandler.requirePositiveLong();
            throw new IllegalArgumentException(REQUIRE_POSITIVE_LONG.getMessage());
        }
    }

    public void multipleOfPrice() throws IllegalArgumentException {
        if (paymentPrice % Number.LOTTO_PRICE.getNumber() != 0) {
            OutputHandler.requireMultipleOfLottoPrice();
            throw new IllegalArgumentException(REQUIRE_MULTIPLE_OF_LOTTO_PRICE.getMessage());
        }
    }
}
