package lotto.domain;

import lotto.validator.BuyerPurchaseAmountValidator;

public class Buyer {
    private int purchaseAmount;
    private int ticketAmount;
    private LottoTickets lottoTickets;

    private Buyer(int purchaseAmount) {
        new BuyerPurchaseAmountValidator().validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.ticketAmount = purchaseAmount / 1000;
    }

    public static Buyer createBuyer(int purchaseAmount) {
        return new Buyer(purchaseAmount);
    }

    public int getTicketAmount() {
        return ticketAmount;
    }
}
