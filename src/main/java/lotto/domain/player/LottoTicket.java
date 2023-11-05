package lotto.domain.player;

import java.util.function.Supplier;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.Lotto;
import lotto.domain.player.playermoney.PlayerWallet;

public class LottoTicket {
    private static final int LOTTO_PRICE = 1000;

    private final int lottoTicket;

    private LottoTicket(int lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public static LottoTicket makeZeroLottoTicket() {
        return new LottoTicket(0);
    }

    LottoTicket changeAllTicketToLotto(Supplier<Lotto> randomLottoSupplier, LottoBundle lottoBundle) {
        if (lottoTicket == 0) {
            return makeZeroLottoTicket();
        }
        addLottoToLottoBundle(randomLotto.get(), lottoBundle);
        int newTicketCount = lottoTicket - 1;
        return new LottoTicket(newTicketCount).changeAllTicketToLotto(randomLotto, lottoBundle);
    }

    private static void addLottoToLottoBundle(Lotto randomLotto, LottoBundle lottoBundle) {
        lottoBundle.addLotto(randomLotto);
    }

    int getLottoTicket() {
        return lottoTicket;
    }
}
