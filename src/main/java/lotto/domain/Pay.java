package lotto.domain;

import lotto.constant.ConfigurationNumbers;
import lotto.util.Validator;

public class Pay {
    private int pay;

    public Pay(int pay) {
        validatePay(pay);
        this.pay = pay;
    }

    private void validatePay(int pay) {
        Validator.lessThanPrice(pay);
        Validator.divisibleByPrice(pay);
    }

    public int getLottoAmounts() {
        return pay / ConfigurationNumbers.PRICE.getNumber();
    }
}
