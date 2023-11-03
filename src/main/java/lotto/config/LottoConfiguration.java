package lotto.config;

import lotto.validation.AmountValidation;

public class LottoConfiguration {
    public AmountValidation amountValidation() {
        return new AmountValidation();
    }
}
