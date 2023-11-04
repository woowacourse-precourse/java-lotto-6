package lotto.controller;

import lotto.LottoFactory;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private LottoService lottoService;
    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {

    }

}
