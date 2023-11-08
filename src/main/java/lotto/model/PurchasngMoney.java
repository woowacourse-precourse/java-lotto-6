package lotto.model;

import java.math.BigDecimal;
import lotto.utils.AmountValidator;

public class PurchasngMoney extends Money{
    public PurchasngMoney(String amount) {
        super(amount);
        BigDecimal purchasingAmount = new BigDecimal(amount);
        AmountValidator.validatePurchasingAmount(purchasingAmount);
    }
}
