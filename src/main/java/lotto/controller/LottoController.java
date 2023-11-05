package lotto.controller;

import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Money money = new Money();

    public void buyLotto() {
        String input = inputView.showInputMoneyMessage();
        money.inputMoney(input);
        int quantity = money.countQuantity();
        outputView.showQuantityMessage(quantity);

    }
}
