package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoService = new LottoService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
}