package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }


    public void play() {

        int lottoAmount = inputView.getPurchaseAmount();

        System.out.println(lottoAmount);


    }


}
