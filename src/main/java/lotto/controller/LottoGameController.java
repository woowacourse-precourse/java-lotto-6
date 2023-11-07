package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.service.LottoResultCalculatorService;
import lotto.service.LottoStoreService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStoreService lottoStoreService;
    private final LottoResultCalculatorService lottoResultCalculatorService;

    public LottoGameController(InputView inputView, OutputView outputView, LottoStoreService lottoStoreService,
                               LottoResultCalculatorService lottoResultCalculatorService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStoreService = lottoStoreService;
        this.lottoResultCalculatorService = lottoResultCalculatorService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = inputView.requestPurchaseAmount();
        List<Lotto> lottos = lottoStoreService.purchaseLotto(purchaseAmount);
        outputView.showPurchasedLottosInformation(lottos);
        WinningNumbers winningNumbers = inputView.requestWinningNumbers();
        LottoResult lottoResult = lottoResultCalculatorService.calculateRanks(lottos, winningNumbers);
        outputView.showResults(lottoResult);
        outputView.showProfitRate(lottoResult.calculateProfitRate(purchaseAmount));
    }
}
