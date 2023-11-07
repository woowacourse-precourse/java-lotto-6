package lotto.domain;

import lotto.Validator.PayValidator;
import lotto.constant.ConfigurationNumbers;

public class Pay {
    private int pay;

    public Pay(int pay) {
        validatePay(pay);
        this.pay = pay;
    }

    private void validatePay(int pay) {
        PayValidator.isNegative(pay);
        PayValidator.lessThanPrice(pay);
        PayValidator.divisibleByPrice(pay);
    }

    public int getLottoAmounts() {
        return pay / ConfigurationNumbers.PRICE.getNumber();
    }
}
