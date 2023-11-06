package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutView;

public class LottoController {

    private final InputView inputView;
    private final OutView outView;

    public LottoController() {
        this.inputView = new InputView();
        this.outView = new OutView();
    }

    public void run() {
        int priceLotto = inputView.parseInputFromUserInteger();
    }
}
