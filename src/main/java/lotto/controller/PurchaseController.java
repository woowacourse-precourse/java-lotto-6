package lotto.controller;
import lotto.view.LottoPurchaseInput;
import lotto.model.LottoTicketCalculator;
public class PurchaseController {

    private final LottoPurchaseInput inputView = new LottoPurchaseInput();
    private final LottoTicketCalculator calculation = new LottoTicketCalculator();

    public int getPurchaseAmount() {
        int amount = inputView.requestPurchaseAmount();
        return calculation.calculateNumberOfTickets(amount);
    }
}