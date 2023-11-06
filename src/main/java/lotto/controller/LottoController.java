package lotto.controller;

import lotto.Money;
import lotto.configuration.InputMessage;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void startLotto() {
        Long money = inputPurchaseAmount();
    }

    private Long inputPurchaseAmount() {
        InputMessage.INPUT_PURCHASE_AMOUNT.inputMoneyMessage();
        Long myMoney = Long.parseLong(InputView.input());
        Money money = new Money(myMoney);
        return money.getMoney();
    }

    private void buyLotto() {
    }
}
