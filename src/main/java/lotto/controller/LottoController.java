package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.LottoLover;
import lotto.view.LottoView;

public class LottoController {

    public void giveMoneyTo(LottoLover buyer) {
        int moneyAmount = LottoView.requestMoneyToUser();
        buyer.earnMoneySomehow(moneyAmount);
    }

    public void brag(LottoLover lottoLover) {
        List<Lotto> lookAtThis
                = lottoLover.bragAboutMyLottoButYouAreNotAllowedToTouchIt();
        LottoView.printPurchaseList(lookAtThis);
    }
}
