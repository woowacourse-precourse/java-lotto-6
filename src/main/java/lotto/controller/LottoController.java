package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.LottoView;

import java.util.List;
import java.util.Map;

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

        Lotto winningLotto = new Lotto(lottoView.inputWinningNumber());
        int bonusNumber = lottoView.inputBonusNumber();

        Map<Rank, Long> results = lottoService.calculateResults(winningLotto, lottos, bonusNumber);
        double profit = lottoService.calculateProfit(lottos, results);

        lottoView.printResult(results, profit);
    }
}
