package lotto.model;

import lotto.util.Validator;

public class LottoAmount {
    private final int amount;

    public LottoAmount(String amount) {

        validate(amount);
        this.amount = Integer.parseInt(amount);


    }

    public int getAmount() {
        return amount;
    }

    private void validate(String amount) {

        Validator.isDigit(amount);
        Validator.notSeparatedBy1000(Integer.parseInt(amount));

    }
}
