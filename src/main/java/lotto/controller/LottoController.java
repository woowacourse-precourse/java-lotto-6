package lotto.controller;

import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.dto.LottoPlayInfo;
import lotto.domain.dto.LottoResult;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public final class LottoController {
    private final LottoPurchaseService lottoPurchaseService;
    private final LottoResultService lottoResultService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoPurchaseService lottoPurchaseService, LottoResultService lottoResultService,
        InputView inputView, OutputView outputView) {
        this.lottoPurchaseService = lottoPurchaseService;
        this.lottoResultService = lottoResultService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        List<Lotto> lottos = lottoPurchaseService.buyLottos(purchaseAmount);
        outputView.displayLottos(lottos);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        LottoResult lottoResult = lottoResultService.getLottoResult(lottos,
            new LottoPlayInfo(winningNumbers, bonusNumber, purchaseAmount));

        List<Rank> ranks = lottoResult.matchedCounts();
        double roi = lottoResult.roi();
        outputView.displayResults(ranks, roi);
    }
}
