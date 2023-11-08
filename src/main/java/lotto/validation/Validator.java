package lotto.validation;

import lotto.View.OutputView;
import lotto.constant.ErrorMessage;

public class Validator {
    public boolean isPriceRight(String input) {
        try {
            int price = Integer.parseInt(input);

            if (!isDividedBy1000(price)) {
                throw new IllegalArgumentException();
            }

            return true;
        } catch (IllegalArgumentException e){
            OutputView.printError(ErrorMessage.NUMBER_RANGE_WRONG.getMessage());

            return false;
        }
    }

    private boolean isDividedBy1000(int price) {
        if (price % 1000 != 0)
            return false;

        return true;
    }
}
