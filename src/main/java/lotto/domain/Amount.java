package lotto.domain;

import lotto.domain.convertor.AmountConvertor;
import lotto.domain.convertor.Convertor;
import lotto.domain.validator.AmountValidator;
import lotto.domain.validator.Validator;

public class Amount {

    private final int amount;

    public Amount(String inputAmount) {
        validateAmount(inputAmount);
        this.amount = convertAmount(inputAmount);
    }

    public int getAmount() {
        return this.amount;
    }

    private void validateAmount(String amountInput) {
        Validator<String> validator = new AmountValidator();
        validator.validate(amountInput);
    }

    private int convertAmount(String amountInput) {
        Convertor<String, Integer> amountConvertor = new AmountConvertor();
        return amountConvertor.convert(amountInput);
    }
}
