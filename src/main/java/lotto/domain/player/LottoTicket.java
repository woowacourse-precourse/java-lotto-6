package lotto.domain.player;

import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.Lotto;
import lotto.domain.player.playermoney.PlayerWallet;

public class LottoTicket {
    private static final int LOTTO_PRICE = 1000;

    private final int lottoTicket;

    public LottoTicket(int lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public LottoTicket issueLottoTicket(PlayerWallet playerWallet) {
        return new LottoTicket(playerWallet.getUsedMoney() / LOTTO_PRICE);
    }

    public LottoTicket changeAllTicketToLotto(Lotto randomLotto, LottoBundle lottoBundle) {
        if (lottoTicket == 0) {
            return new LottoTicket(0);
        }
        addLottoToLottoBundle(randomLotto, lottoBundle);
        int newTicketCount = lottoTicket - 1;
        return new LottoTicket(newTicketCount).changeAllTicketToLotto(randomLotto, lottoBundle);
    }

    private static void addLottoToLottoBundle(Lotto randomLotto, LottoBundle lottoBundle) {
        lottoBundle.addLotto(randomLotto);
    }

    public int getLottoTicket() {
        return lottoTicket;
    }
}
