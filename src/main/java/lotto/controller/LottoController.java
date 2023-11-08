package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.validation.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService = new LottoService(new InputView(), new OutputView(), new Validation(), new Lottos());

    public void run() {
        lottoService.createPlayer();
        lottoService.createWinningLotto();
        lottoService.createRevenue();
    }
}
