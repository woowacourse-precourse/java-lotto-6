package lotto.controller;

import lotto.service.LottoGenerator;
import lotto.service.NumberGenerator;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String purchaseAmount = inputView.readPurchaseAmount();
        NumberGenerator<List<Integer>> generator = new LottoGenerator();

    }
}
