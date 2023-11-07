package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {

    private final LottoView lottoView;
    private final LottoService lottoService;

    public LottoController(LottoView lottoView, LottoService lottoService) {
        this.lottoView = lottoView;
        this.lottoService = lottoService;
    }

    public void play() {
        int purchaseAmount = lottoView.inputPurchaseAmount();
        List<Lotto> lottos = lottoService.buyLotto(purchaseAmount);
        lottoView.printLottos(lottos);
    }
}
