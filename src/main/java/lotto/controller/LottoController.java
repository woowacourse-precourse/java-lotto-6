package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoBuilder;
import lotto.domain.Money;
import lotto.domain.LottoTicket;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    public void run() {
        Money money = purchaseLotto();
        LottoTicket lottoTicket = createLottoTicket(money);
        printLottoList(lottoTicket);
    }

    private void printLottoList(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottoList()) {
            Output.printLottoList(lotto);
        }
    }

    private LottoTicket createLottoTicket(Money money) {
        LottoBuilder lottoBuilder = new LottoBuilder();
        return lottoBuilder.createLotto(money);
    }

    private Money purchaseLotto() {
        Output.getMessageOfPurchaseLotto();
        Money money = new Money(Input.getPurchaseMoney());
        Output.getFormatOfPurchaseMessage(money.getLottoCount());
        return money;
    }
}
