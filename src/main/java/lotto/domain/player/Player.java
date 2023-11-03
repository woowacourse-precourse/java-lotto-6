package lotto.domain.player;

import lotto.domain.player.playermoney.PlayerMoney;

public class Player {
    private final PlayerMoney playerMoney;
    private LottoTicket lottoTicket;

    public Player(int inputMoney) {
        this.playerMoney = new PlayerMoney(inputMoney);
        this.lottoTicket = new LottoTicket(0);
    }

    public void consumeAllMoneyToLottoTicket() {
        playerMoney.consumeMoneyToLottoTicket(playerMoney.getHoldingMoney());
        lottoTicket = lottoTicket.issueLottoTicket(playerMoney);
    }

    public int getTicketNumber() {
        return lottoTicket.getLottoTicket();
    }
}
