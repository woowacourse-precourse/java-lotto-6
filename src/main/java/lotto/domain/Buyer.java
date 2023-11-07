package lotto.domain;

import lotto.util.BusinessVaildator;

public class Buyer {
    private int purchaseAmount;
    private int ticketQuantity;
    private int winningAmount;

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        BusinessVaildator.vaildateCurrencyAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(int winningAmount) {
        this.winningAmount = winningAmount;
    }
}
