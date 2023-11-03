package lotto.domain.player;

import lotto.domain.lotto.Lotties;
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

    public LottoTicket changeAllTicketToLotto(Lotto randomLotto, Lotties lotties) {
        if (lottoTicket == 0) {
            return new LottoTicket(0);
        }
        addLottoToLotties(randomLotto, lotties);
        int newTicketCount = lottoTicket - 1;
        return new LottoTicket(newTicketCount).changeAllTicketToLotto(randomLotto, lotties);
    }

    private static void addLottoToLotties(Lotto randomLotto, Lotties lotties) {
        lotties.addLotto(randomLotto);
    }

    public int getLottoTicket() {
        return lottoTicket;
    }
}
