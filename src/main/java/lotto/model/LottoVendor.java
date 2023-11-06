package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.IntStream;

public class LottoVendor {

    private static final BigDecimal PRICE_A_LOTTO = BigDecimal.valueOf(1000);

    public List<Lotto> purchaseLotto(BigDecimal paymentAmount) {
        validateAmount(paymentAmount);
        int count = calculateLottoCount(paymentAmount);
        return generateRandomLotteries(count);
    }

    private List<Lotto> generateRandomLotteries(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> Lotto.generateGandomLotto())
                .toList();
    }

    private void validateAmount(BigDecimal paymentAmount) {
        validateNull(paymentAmount);
        validatePaymentAmountIsMultipleOf1000(paymentAmount);
    }

    private void validateNull(BigDecimal paymentAmount) {
        if(paymentAmount == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePaymentAmountIsMultipleOf1000(BigDecimal paymentAmount) {
        if(isPaymentNotDivisibleByLottoPrice(paymentAmount)) {
            throw new IllegalArgumentException();
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
