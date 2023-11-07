package lotto;

import lotto.domain.BuyLottoInfo;
import lotto.domain.PurchaseTickets;
import lotto.domain.WinningLotto;

import java.util.List;

public class LottoService {

    private WinningLotto winningLotto;
    private PurchaseTickets purchaseTickets;

    public BuyLottoInfo createLottoTickets(int amount) {
        purchaseTickets = new PurchaseTickets(amount);
        return purchaseTickets.getBuyLottoInfo();
    }
}
