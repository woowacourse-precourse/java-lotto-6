package lotto.domain;

import lotto.validator.Errors;
import lotto.view.Output;

public class Amount {

    private int amount;

    public Amount(Integer amount) {
        validateDividedByLottoPrice(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }


    private void validateDividedByLottoPrice(Integer amount) {
        if (amount % Lotto.PRICE != 0) {
            Output.printErrorMessage(Errors.AMOUNT_NOT_DIVIDED.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
