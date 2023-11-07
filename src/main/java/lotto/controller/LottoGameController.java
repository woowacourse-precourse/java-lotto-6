package lotto.controller;

import lotto.exception.InputExceptionConstant;
import lotto.service.LottoGameService;
import lotto.util.InputValidator;
import lotto.util.LottoGameUtil;
import lotto.view.InputView;

public class LottoGameController {

    private final InputView inputView;
    private final LottoGameService service;

    public LottoGameController(InputView inputView, LottoGameService service) {
        this.inputView = inputView;
        this.service = service;
    }

    public void run() {
        initGame();
    }

    private void initGame() {
        int purchaseAmount = setPurchaseAmount();

    }

    private int setPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmount = inputView.inputPurchaseAmount();
                InputValidator.validatePurchaseNumber(purchaseAmount);

                return LottoGameUtil.StringToInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(InputExceptionConstant.ONLY_NATURAL_NUMBER_IN_STRING.getText());
            }
        }
    }
}
