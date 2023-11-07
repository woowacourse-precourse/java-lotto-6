package lotto.outputPrint;

import lotto.readUserInput.PurchaseAmount;
import lotto.service.PurchasedLottoTickets;

public class PurchasedLottoNumbersPrint {
    private PurchasedLottoTickets purchasedLottoTickets;
    private PurchaseAmount purchaseAmount;

    public PurchasedLottoNumbersPrint(PurchasedLottoTickets purchasedLottoTickets, PurchaseAmount purchaseAmount) {
        this.purchasedLottoTickets = purchasedLottoTickets;
        this.purchaseAmount = purchaseAmount;
    }

    public void printTickets() {
        purchasedLottoTickets.textForTicketsPrint();
    }

    public void purchaseCompletePrint() {
        System.out.println(purchaseAmount.purchasedAmountPrint());
    }
}
