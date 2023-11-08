package lotto.domain;

import lotto.Validator.NumberValidator;
import lotto.Validator.PayValidator;
import lotto.constant.ConfigurationNumbers;
import lotto.util.Parser;

public class Pay {
    private int pay;

    public Pay(String input) {
        int pay = Parser.toInteger(input);
        validatePay(pay);
        this.pay = pay;
    }

    private void validatePay(int pay) {
        NumberValidator.isNegative(pay);
        PayValidator.lessThanPrice(pay);
        PayValidator.divisibleByPrice(pay);
    }

    public int getLottoAmounts() {
        return pay / ConfigurationNumbers.PRICE.getNumber();
    }
}
