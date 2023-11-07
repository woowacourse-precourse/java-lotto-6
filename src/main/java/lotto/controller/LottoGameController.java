package lotto.controller;

import lotto.constants.ErrorMessage;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final OutputView outputView;
    private final InputView inputView;

    public LottoGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        PurchaseAmount purchaseAmount = setPurchaseAmount();
    }

    public PurchaseAmount setPurchaseAmount() {
        try {
            outputView.printInputPurchaseAmount();
            String amount = inputView.inputPurchaseAmount();
            return new PurchaseAmount(amount);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.PURCHASE_AMOUNT_NOT_DIGIT.getMessage());
            setPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setPurchaseAmount();
        }
        return null;
    }
}
