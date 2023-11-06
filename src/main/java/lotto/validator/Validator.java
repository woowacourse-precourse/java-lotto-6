package lotto.validator;

import lotto.controller.LottoController;

public class Validator {
    private Validator() {
    }

    public static boolean isPurchaseAmountValid(String input) {
        if (!isNumeric(input)) {
            return false;
        }
        int purchaseAmount = Integer.parseInt(input);
        if (isDividedByLottoPrice(purchaseAmount)) {
            return true;
        }
        return false;
    }

    public static boolean isDividedByLottoPrice(int money) {
        if (money / LottoController.LOTTO_PRICE == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }
}
