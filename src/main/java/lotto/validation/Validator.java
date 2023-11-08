package lotto.validation;

import lotto.View.OutputView;
import lotto.constant.ErrorMessage;

public class Validator {
    public boolean isAmountRight(String input) {
        try {
            int amount = Integer.parseInt(input);

            if (amount == 0 || !isDividedBy1000(amount)) {
                throw new IllegalArgumentException();
            }

            return true;
        } catch (IllegalArgumentException e){
            OutputView.printError(ErrorMessage.NUMBER_RANGE_WRONG.getMessage());

            return false;
        }
    }

    private boolean isDividedBy1000(int amount) {
        if (amount % 1000 != 0)
            return false;

        return true;
    }
}
