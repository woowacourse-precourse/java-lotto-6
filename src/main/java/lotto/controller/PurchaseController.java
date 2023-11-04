package lotto.controller;
import lotto.view.LottoPurchaseInput;
import lotto.model.LottoTicketCalculator;
public class PurchaseController {

    private final LottoPurchaseInput inputView = new LottoPurchaseInput();

    public int getPurchaseAmount() {
        return inputView.requestPurchaseAmount();
    }
}