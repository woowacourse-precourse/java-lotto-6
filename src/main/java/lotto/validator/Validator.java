package lotto.validator;

import lotto.controller.LottoController;

public class Validator {
    private Validator() {
    }

    public static boolean validatePurchaseAmount(int purchaseAmount) {

    }

    public static boolean validateDivideByLottoPrice(int money) {
        if (money / LottoController.LOTTO_PRICE == 0) {
            return true;
        }
        return false;
    }
}
