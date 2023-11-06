package lotto.controller;

import lotto.model.Jackpot;
import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.model.Result;

import java.util.List;

public class LottoController {

    // 로또 구매
    public Purchase purcahseLottos(String amount) {
        return Purchase.fromPurchaseAmount(amount);
    }

    // 로또 발급
    public List<Lotto> generateLottoTicket(int purchaseCount) {
        return Lotto.purchaseLottos(purchaseCount);
    }
    
}
