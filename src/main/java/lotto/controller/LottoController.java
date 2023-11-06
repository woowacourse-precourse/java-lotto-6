package lotto.controller;

import lotto.service.LottoBuyer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoBuyer lottoBuyer;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoBuyer lottoBuyer, InputView inputView, OutputView outputView) {
        this.lottoBuyer = lottoBuyer;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

    }
}
