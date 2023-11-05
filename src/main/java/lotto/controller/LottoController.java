package lotto.controller;

import static lotto.view.constant.InputMessage.GET_PURCHASE_AMOUNT_MESSAGE;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;

    public LottoController() {
        this.inputView = new InputView();
    }

    public void play() {
        String purchaseAmount = getPurchaseAmount();
    }

    public String getPurchaseAmount() {
        OutputView.printMessage(GET_PURCHASE_AMOUNT_MESSAGE.getMessage());
        return inputView.readAmountInput();
    }
}
