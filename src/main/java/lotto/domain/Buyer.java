package lotto.domain;

import lotto.util.BusinessVaildator;

import java.util.List;

public class Buyer {
    private int purchaseAmount;
    private int ticketQuantity;
    private List<List<Integer>> lottos;
    private int winningAmount;

    public Buyer(String inputMoney) {
        int purchaseAmount = Integer.parseInt(inputMoney);
        BusinessVaildator.vaildateCurrencyAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

    public void setLottos(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(int winningAmount) {
        this.winningAmount = winningAmount;
    }


}
