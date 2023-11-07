package lotto;

import lotto.domain.BuyLottoInfo;
import lotto.domain.PurchaseLottos;
import lotto.domain.WinningLotto;

import java.util.List;

public class LottoService {

    private WinningLotto winningLotto;
    private PurchaseLottos purchaseTickets;

    public BuyLottoInfo createLottoTickets(int amount) {
        purchaseTickets = new PurchaseLottos(amount);
        return purchaseTickets.getBuyLottoInfo();
    }
}
