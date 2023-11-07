package lotto.controller;

import static lotto.view.constant.InputMessage.GET_PURCHASE_AMOUNT_MESSAGE;

import lotto.domain.LottoPurchase;
import lotto.service.LottoPurchaseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoPurchaseController {

    private final InputView inputView;
    private final LottoPurchaseService lottoPurchaseService;

    public LottoPurchaseController() {
        this.inputView = new InputView();
        this.lottoPurchaseService = new LottoPurchaseService();
    }

    public LottoPurchase getLottoPurchase() {
        String purchaseAmount = getPurchaseAmount();
        return lottoPurchaseService.createLottoPurchase(purchaseAmount);
    }

    public String getPurchaseAmount() {
        OutputView.printMessage(GET_PURCHASE_AMOUNT_MESSAGE.getMessage());
        return inputView.readPurchaseAmount();
    }
}
