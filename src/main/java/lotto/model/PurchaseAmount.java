package lotto.model;

import static lotto.configurations.ErrorMessages.*;
import static lotto.configurations.SettingValues.*;

public class PurchaseAmount {
    private Long paidMoney;

    public PurchaseAmount(Long paidMoney) {
        validate(paidMoney);
        this.paidMoney = paidMoney;
    }

    public Integer getNumberOfLotto() {
        return Math.toIntExact(paidMoney / PRICE_OF_LOTTO.get());
    }

    private void validate(Long paidMoney) {
        validatePurchaseUnit(paidMoney);
        validateIntegerRange(paidMoney);
    }

    private void validatePurchaseUnit(Long paidMoney) {
        if (paidMoney.intValue() % PRICE_OF_LOTTO.get() != 0) {
            throw new IllegalArgumentException(ERROR_HEADER.get() + INVALID_UNIT_MESSAGE.get());
        }
    }

    private void validateIntegerRange(Long paidMoney) {
        long numberOfTicket = paidMoney / PRICE_OF_LOTTO.get();
        if (numberOfTicket > (long) Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_HEADER.get() + OUT_OF_RANGE_PURCHASE_MESSAGE.get());
        }
    }
}
