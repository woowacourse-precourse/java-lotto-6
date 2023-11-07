package lotto.outputPrint;

import lotto.service.PurchasedLottoTickets;

public class PurchasedLottoNumbersPrint {
    private PurchasedLottoTickets purchasedLottoTickets;

    public PurchasedLottoNumbersPrint(PurchasedLottoTickets purchasedLottoTickets) {
        this.purchasedLottoTickets = purchasedLottoTickets;
    }

    public void printTickets() {
        purchasedLottoTickets.textForTicketsPrint();
    }
}
