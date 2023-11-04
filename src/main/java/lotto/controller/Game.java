package lotto.controller;

import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.service.UserService;
import lotto.view.View;

public class Game {
    private final UserService userService = new UserService();
    private final LottoService lottoService = new LottoService();
    private final ResultService resultService = new ResultService();

    public void start() {

        boolean isValidPurchaseAmount = false;
        while (!isValidPurchaseAmount) {
            String purchaseAmountInput = View.inputPurchaseAmount();
            try {
                userService.validatePurchaseAmount(purchaseAmountInput);
                isValidPurchaseAmount = true;
            } catch (IllegalArgumentException e) {
                View.printMessage(e.getMessage());
            }
        }

        userService.purchaseLottos();


    }
}
