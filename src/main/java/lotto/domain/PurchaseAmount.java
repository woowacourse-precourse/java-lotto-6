package lotto.domain;

import static lotto.util.Validator.*;

public class PurchaseAmount {
    private final String amount;

    public PurchaseAmount(String amount) {
        validateNonNumeric(amount);
        validateUnit(amount);
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }
}
