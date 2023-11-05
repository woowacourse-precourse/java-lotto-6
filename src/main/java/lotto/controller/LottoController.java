package lotto.controller;

import lotto.dto.MoneyDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        outputView.beforeInputMoney();
        MoneyDto moneyDto = new MoneyDto(inputView.inputMoney());
    }
}
