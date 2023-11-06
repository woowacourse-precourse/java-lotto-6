package lotto.controller;

import lotto.model.LottoMoneyValidator;
import lotto.util.Utils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        String inputMoney = inputView.readLottoMoney();
        int lottoAmount = LottoMoneyValidator.validateMoneyIsValid(inputMoney);
        outputView.printLottoMoney(lottoAmount);
    }
}
