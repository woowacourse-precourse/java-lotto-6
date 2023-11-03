package lotto.domain.player;

import lotto.domain.player.playermoney.PlayerWallet;

public class Player {
    private final PlayerWallet playerWallet;
    private LottoTicket lottoTicket;

    public Player(int inputMoney) {
        this.playerWallet = new PlayerWallet(inputMoney);
        this.lottoTicket = new LottoTicket(0);
    }

    public void consumeAllMoneyToLottoTicket() {
        playerWallet.consumeMoneyToLottoTicket(playerWallet.getHoldingMoney());
        lottoTicket = lottoTicket.issueLottoTicket(playerWallet);
    }

    public int getTicketNumber() {
        return lottoTicket.getLottoTicket();
    }
}
