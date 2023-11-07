package lotto.controller;

import lotto.domain.Money;
import lotto.domain.LottoTicket;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    public void run() {
        Money money = purchaseLotto();
    }

    private Money purchaseLotto() {
        Output.getMessageOfPurchaseLotto();
        Money money = new Money(Input.getPurchaseMoney());
        Output.getFormatOfPurchaseMessage(money.getLottoCount());
        return money;
    }
}
