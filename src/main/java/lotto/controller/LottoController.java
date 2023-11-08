package lotto.controller;

import lotto.LottoLover;
import lotto.view.LottoView;

public class LottoController {

    public void giveMoneyTo(LottoLover buyer) {
        int moneyAmount = LottoView.requestMoneyToUser();
        buyer.earnMoneySomehow(moneyAmount);
    }
}
