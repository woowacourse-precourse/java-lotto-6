package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

import java.util.List;

public class GameController {

    InputView inputView = new InputView();
    public void init() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        LottoCount lottoCount = LottoCount.from(purchaseAmount);
        List<Lotto> autoLottoTickets = Lotto.getAutoLottoTickets(lottoCount);
    }

    public PurchaseAmount getPurchaseAmount() {
        while (true) {
            try {
                return PurchaseAmount.from(inputView.readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
