package lotto.controller;

import static lotto.view.constant.InputMessage.GET_PURCHASE_AMOUNT_MESSAGE;

import lotto.domain.LottoPurchase;
import lotto.service.LottoPurchaseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final LottoPurchaseService lottoPurchaseService;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoPurchaseService = new LottoPurchaseService();
    }

    public void play() {
        String purchaseAmount = getPurchaseAmount();
        LottoPurchase lottoPurchase = lottoPurchaseService.createLottoPurchase(purchaseAmount);
    }

    public String getPurchaseAmount() {
        OutputView.printMessage(GET_PURCHASE_AMOUNT_MESSAGE.getMessage());
        return inputView.readAmountInput();
    }
}
