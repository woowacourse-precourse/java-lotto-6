package lotto.checker;

import lotto.constant.ExceptionMessage;
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
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_POSITIVE_LONG.getMessage());
        }
    }

    public void multipleOfPrice() throws IllegalArgumentException {
        if (paymentPrice % Number.LOTTO_PRICE.getNumber() != 0) {
            OutputHandler.requireMultipleOfLottoPrice();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_MULTIPLE_OF_LOTTO_PRICE.getMessage());
        }
    }
}
