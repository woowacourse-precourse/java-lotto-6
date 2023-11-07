package lotto.model;

import lotto.util.Validator;
import lotto.view.InputView;

public class LottoAmount {
    private final int amount;

    public LottoAmount(String amount) {
        validation(amount);
        this.amount = Integer.parseInt(amount);
    }

    public int getAmount() {
        return amount;
    }

    private void validation(String amount){
        Validator.isDigit(amount);
        Validator.notSeparatedBy1000(Integer.parseInt(amount));
    }
}
