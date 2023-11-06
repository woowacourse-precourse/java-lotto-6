package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void launch() {
        int money = inputView.inputPurchaseMoney();

        List<Lotto> lottos = lottoService.buyLotto(money);
        outputView.printPurchasedLottos(lottos);
    }
}
