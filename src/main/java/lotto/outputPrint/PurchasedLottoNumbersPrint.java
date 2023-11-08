package lotto.outputPrint;

import lotto.readUserInput.PurchaseAmount;
import lotto.service.PurchasedLottoTickets;

public class PurchasedLottoNumbersPrint {
    private PurchasedLottoTickets purchasedLottoTickets;

    public PurchasedLottoNumbersPrint(PurchasedLottoTickets purchasedLottoTickets) {
        this.purchasedLottoTickets = purchasedLottoTickets;
    }

    public void printTickets() {
        purchasedLottoTickets.textForTicketsPrint();
    }

    public void purchaseCompletePrint(PurchaseAmount purchaseAmount) {
        System.out.println(purchaseAmount.purchasedAmountPrint());
    }
}
