package validation;

import view.OutputMessage;

public class LottoValidation {
    private static final int LOTTO_PRICE = 1000;

    public boolean validateInputPrice(int inputPrice) {

        if (inputPrice % LOTTO_PRICE != 0) {
            return false;
        }
        return true;
    }

    public boolean isBiggerThanZero(int inputPrice) {
        if (inputPrice < 0) {
            return false;
        }
        return true;
    }
}
