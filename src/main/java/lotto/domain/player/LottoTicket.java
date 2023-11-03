package lotto.domain.player;

import lotto.domain.player.playermoney.PlayerMoney;

public class LottoTicket {
    private static final int LOTTO_PRICE = 1000;

    private final int lottoTicket;

    public LottoTicket(int lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public LottoTicket issueLottoTicket(PlayerMoney playerMoney) {
        return new LottoTicket(playerMoney.getUsedMoney() / LOTTO_PRICE);
    }

    public int getLottoTicket() {
        return lottoTicket;
    }
}
