package lotto.service;

import lotto.model.InputValidation;
import lotto.view.InputView;

public class LottoService {
    private static final int DIVIDED_AMOUNT = 1000;
    private int lottoCount;

    public void createLottoCount() {
        while (true) {
            try {
                lottoCount = checkLottoCount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int checkLottoCount() {
        int validAmount = checkPurchaseAmount();
        return calculateLottoCount(validAmount);
    }

    public int checkPurchaseAmount() {
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
