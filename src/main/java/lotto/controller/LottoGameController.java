package lotto.controller;

import lotto.domain.model.LottoMoney;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    InputView inputView;
    OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private LottoMoney readLottoMoney() {
        while (true) {
            outputView.printReadMoneyAmountMessage();

            try {
                return new LottoMoney(inputView.readMoneyAmount());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void play() {
        LottoMoney lottoMoney = readLottoMoney();

    }
}
