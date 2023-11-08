package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoNumberGenerationService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultCalculationService;
import lotto.service.LottoWinningNumberService;

public class LottoGameController {

    private final LottoNumberGenerationService lottoNumberGenerationService;
    private final LottoPurchaseService lottoPurchaseService;
    private final LottoResultCalculationService lottoResultCalculationService;
    private final LottoWinningNumberService lottoWinningNumberService;

    public LottoGameController(LottoNumberGenerationService lottoNumberGenerationService,
            LottoPurchaseService lottoPurchaseService,
            LottoResultCalculationService lottoResultCalculationService,
            LottoWinningNumberService lottoWinningNumberService) {

        this.lottoNumberGenerationService = lottoNumberGenerationService;
        this.lottoPurchaseService = lottoPurchaseService;
        this.lottoResultCalculationService = lottoResultCalculationService;
        this.lottoWinningNumberService = lottoWinningNumberService;
    }

    public List<Lotto> buyLottoTickets(String purchaseAmount) {
        int lottoTicketsCount = lottoPurchaseService.calculateNumberOfLottoTickets(purchaseAmount);
        return lottoNumberGenerationService.generateLottoNumbers(lottoTicketsCount);
    }

    public WinningLotto createWinningLotto(String winningNumbers, String bonusNumber) {
        return lottoWinningNumberService.createWinningLotto(winningNumbers, bonusNumber);
    }

    public Map<Integer, Integer> calculateMatchingCounts(List<Lotto> userLottoNumbers, WinningLotto winningLotto) {
        return lottoResultCalculationService.calculateMatchingCounts(userLottoNumbers, winningLotto);
    }

    public void printStatisticsAndReturnRate(Map<Integer, Integer> matchingCounts, int lottoTicketsCount) {
        lottoResultCalculationService.printStatistics(matchingCounts);
        lottoResultCalculationService.printReturnRate(matchingCounts, lottoTicketsCount);
    }
}
