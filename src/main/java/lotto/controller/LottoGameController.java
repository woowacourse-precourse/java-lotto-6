package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.service.LottoRankCalculatorService;
import lotto.service.LottoStoreService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStoreService lottoStoreService;
    private final LottoRankCalculatorService lottoRankCalculatorService;

    public LottoGameController(InputView inputView, OutputView outputView, LottoStoreService lottoStoreService,
                               LottoRankCalculatorService lottoRankCalculatorService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStoreService = lottoStoreService;
        this.lottoRankCalculatorService = lottoRankCalculatorService;
    }

    public void run() {
        //구입 금액 받기
        PurchaseAmount purchaseAmount = inputView.requestPurchaseAmount();

        //구입 금액 어치 로또 구매
        List<Lotto> lottos = lottoStoreService.purchaseLotto(purchaseAmount);

        //로또 정보 출력
        outputView.showPurchasedLottosInformation(lottos);

        //당첨 정보 입력 받기
        WinningNumbers winningNumbers = inputView.requestWinningNumbers();

        //당첨 등수 계산
        LottoResult lottoResult = lottoRankCalculatorService.calculateRanks(lottos, winningNumbers);

        //ranks 뷰 전달
        outputView.showResults(lottoResult);

        //수익률 뷰 전달
        outputView.showProfitRate(lottoResult.getProfitRate(purchaseAmount));
    }
}
