package lotto.model;

import static lotto.common.exception.PurchaseAmountErrorMessage.NOT_DIVIDE_BY_LOTTO_PRICE;
import static lotto.common.exception.PurchaseAmountErrorMessage.NOT_NEGATIVE_NUMBER;
import static lotto.common.exception.PurchaseAmountErrorMessage.NOT_NULL;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.IntStream;
import lotto.common.exception.PurchaseAmountException;

public class LottoVendor {

    private static final BigDecimal PRICE_A_LOTTO = BigDecimal.valueOf(1000);

    public List<Lotto> purchaseLotto(BigDecimal paymentAmount) {
        validateAmount(paymentAmount);
        int count = calculateLottoCount(paymentAmount);
        return generateRandomLotteries(count);
    }

    public BigDecimal calculateTotalPrice(int count) {
        return PRICE_A_LOTTO.multiply(BigDecimal.valueOf(count));
    }

    private List<Lotto> generateRandomLotteries(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> Lotto.generateGandomLotto())
                .toList();
    }

    private void validateAmount(BigDecimal paymentAmount) {
        validateNull(paymentAmount);
        validatePaymentAmountIsMultipleOf1000(paymentAmount);
        validateNonPositivePaymentAmount(paymentAmount);
    }

    private void validateNull(BigDecimal paymentAmount) {
        if(paymentAmount == null) {
            throw new PurchaseAmountException(NOT_NULL);
        }
    }

    private void validatePaymentAmountIsMultipleOf1000(BigDecimal paymentAmount) {
        if(isPaymentNotDivisibleByLottoPrice(paymentAmount)) {
            throw new PurchaseAmountException(NOT_DIVIDE_BY_LOTTO_PRICE);
        }
    }

    private void validateNonPositivePaymentAmount(BigDecimal paymentAmount) {
        if (paymentAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new PurchaseAmountException(NOT_NEGATIVE_NUMBER);
        }
    }

    private boolean isPaymentNotDivisibleByLottoPrice(BigDecimal paymentAmount) {
        return !paymentAmount.remainder(PRICE_A_LOTTO)
                .equals(BigDecimal.ZERO);
    }

    private int calculateLottoCount(BigDecimal paymentAmount) {
        return paymentAmount.divide(PRICE_A_LOTTO, RoundingMode.DOWN)
                .intValue();
    }

}
