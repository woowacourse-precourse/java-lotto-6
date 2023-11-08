package lotto.controller;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Lottos lottos = new Lottos(inputView.requirePurchas());
        outputView.anounceLottos(lottos);
    }
}
