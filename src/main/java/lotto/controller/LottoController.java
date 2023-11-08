package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.View;

public class LottoController {
    private final LottoService lottoService;
    private final View view;

    public LottoController(LottoService lottoService, View view) {
        this.lottoService = lottoService;
        this.view = view;
    }

    public void run() {
        Amount amount = view.getAmount();
        Lottos lottos = lottoService.createLottos(amount);
        view.printCreatedLottos(amount, lottos);
        WinningLotto winningLotto = view.getWinningLotto();
        Result result = lottoService.createResult(lottos, winningLotto);
        view.printResult(result, amount);
    }
}
