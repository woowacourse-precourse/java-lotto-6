package lotto.controller;

import lotto.model.InputValidation;
import lotto.view.InputView;

public class LottoGame {
    private static final int DIVIDED_AMOUNT = 1000;

    public void start() {
        int lottoCount = getLottoCount();
    }

    public int getLottoCount() {
        int validAmount = inputPurchaseAmount();
        return calculateLottoCount(validAmount);
    }

    public int inputPurchaseAmount() {
        String amount = InputView.purchaseAmount();
        return checkNumber(amount);
    }

    public int checkNumber(String amount) {
        InputValidation.validateNumber(amount);
        return Integer.parseInt(amount);
    }

    public int calculateLottoCount(int validAmount) {
        InputValidation.validatePurchaseAmount(validAmount);
        return validAmount / DIVIDED_AMOUNT;
    }
}
