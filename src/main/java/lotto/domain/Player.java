package lotto.domain;

import java.util.List;

public class Player {
    private static final int AMOUNT_UNIT = 1_000;
    private PlayerBuyPrice playerBuyPrice;
    private LottoTicket lottoTicket;
    private int winningPrice;

    public Player(final String amount) {
        this.playerBuyPrice = new PlayerBuyPrice(amount);
        this.winningPrice = 0;
    }

    public void setLottoTicket(final LottoTicket lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public int getPlayerBuyPrice() {
        return Integer.parseInt(playerBuyPrice.amount());
    }

    public int getPlayerTicketQuantity(){
        return Integer.parseInt(playerBuyPrice.amount()) / AMOUNT_UNIT;
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket.lottoTicket();
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public void addWinningPrice(int revenue) {
        winningPrice += revenue;
    }
}
