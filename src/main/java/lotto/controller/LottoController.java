package lotto.controller;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start(){
        Lottos lottos = new Lottos(inputView.readBuyAmount());
    }

}
