package lotto.data;

import java.math.BigDecimal;
import lotto.message.ErrorMessage;
import lotto.utils.Util;

public class Amount extends BigDecimal {
    public Amount(String val, BigDecimal lottoPrice) {
        super(val);
        validate(this, lottoPrice);
    }

    private static void validate(BigDecimal purchaseAmount, BigDecimal lottoPrice) {
        if (purchaseAmount.compareTo(lottoPrice) < 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_IS_LESS_THAN_LOTTO_PRICE.getMessage());
        }
        Util.validateMultiplesOf(purchaseAmount, lottoPrice);
    }
}
