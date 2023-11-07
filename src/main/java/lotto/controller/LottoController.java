package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    public void run() {
        Money money = purchaseLotto();
        LottoTicket lottoTicket = createLottoTicket(money);
        printLottoList(lottoTicket);
        WinningLotto winningLotto = createWinningLottoTicket();
    }

    private WinningLotto createWinningLottoTicket() {
        while (true) {
            try {
                LottoBuilder lottoBuilder = new LottoBuilder();
                Output.getMessageOfInputWinningNumber();
                return new WinningLotto(lottoBuilder.createWinningLotto(Input.getWinningNumber()));
            } catch (IllegalArgumentException e) {
                Output.getErrorMessage(e);
            }
        }
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
        while (true) {
            try {
                Output.getMessageOfPurchaseLotto();
                Money money = new Money(Input.getPurchaseMoney());
                Output.getFormatOfPurchaseMessage(money.getLottoCount());

                return money;
            } catch (IllegalArgumentException e) {
                Output.getErrorMessage(e);
            }
        }
    }
}
