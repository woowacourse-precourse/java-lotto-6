package lotto.model;

import lotto.util.Validator;
import lotto.view.InputView;

public class LottoAmount {
    private final int amount;

    public LottoAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validation(int amount){
        Validator.notSeparatedBy1000(amount);

    }
}
