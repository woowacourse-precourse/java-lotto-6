package lotto.controller;

import lotto.domain.Repeater;
import lotto.domain.model.LottoMoney;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    InputView inputView;
    OutputView outputView;
    Repeater repeater;

    public LottoGameController(InputView inputView, OutputView outputView, Repeater repeater) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.repeater = repeater;
    }

    private LottoMoney readLottoMoney() {
        return repeater.repeatBeforeSuccess(() ->  new LottoMoney(inputView.readCostAmount()));
    }

    public void play() {
        LottoMoney lottoMoney = readLottoMoney();

    }
}