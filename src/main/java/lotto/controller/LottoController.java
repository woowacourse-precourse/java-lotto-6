package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BuyAmount;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResults;
import lotto.domain.LottoResultsDTO;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoGenerator lottoGenerator;
    private Lottos lottos;
    private WinningNumbers winningNumbers;

    public LottoController(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        buyLotto();
        drawLotto();
        winningStatistics();
    }

    private void buyLotto() {
        long inputBuyAmount = InputView.getBuyAmountFromInput();
        BuyAmount buyAmount = new BuyAmount(inputBuyAmount);
        lottos = new Lottos(lottoGenerator.generateLottos(buyAmount.getAbleToBuyCount()));
        OutputView.displayAllLottos(lottos.toLottosDTO());
    }

    private void drawLotto() {
        List<Integer> winningNumber = InputView.getWinningNumberFromInput();
        int bonusNumber = InputView.getBonusNumberFromInput();
        winningNumbers = new WinningNumbers(winningNumber, bonusNumber);
    }

    private void winningStatistics() {
        LottoResultsDTO resultDTO = createLottoResultsDTO();
        OutputView.displayAllLottosStatistics(resultDTO);
        OutputView.displayRateOfReturn(resultDTO);
    }

    private LottoResultsDTO createLottoResultsDTO() {
        List<LottoResults> lottoResults = lottos.calculateAllOfLottoResult(winningNumbers);
        Map<LottoResults, Integer> lottoStatistics = new HashMap<>();
        for (LottoResults result : lottoResults) {
            lottoStatistics.put(result, lottoStatistics.getOrDefault(result, 0) + 1);
        }
        long winningAmount = calculateTotalWinningAmount(lottoStatistics);
        return new LottoResultsDTO(lottoStatistics, winningAmount, lottoResults.size());
    }

    private long calculateTotalWinningAmount(Map<LottoResults, Integer> lottoStatistics) {
        long totalAmount = 0;
        for (LottoResults lottoResults : LottoResults.values()) {
            long winningAmount = lottoResults.getWinningAmount();
            int rankCount = lottoStatistics.getOrDefault(lottoResults, 0);
            totalAmount += winningAmount * rankCount;
        }
        return totalAmount;
    }
}
