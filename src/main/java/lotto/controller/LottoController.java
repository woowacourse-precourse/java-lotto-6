package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.BuyAmount;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResults;
import lotto.domain.LottoResultsDTO;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoGenerator lottoGenerator;
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private BuyAmount buyAmount;

    public LottoController(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        buyLotto();
        drawLotto();
        generateWinningStatistics();
    }

    private void buyLotto() {
        buyAmount = getValidBuyAmountFromInput();
        lottos = new Lottos(lottoGenerator.generateLottos(buyAmount.getAbleToBuyCount()));
        OutputView.displayAllLottos(lottos.toLottosDTO());
    }

    private void drawLotto() {
        WinningNumber winningNumber = getValidWinningNumberFromInput();
        BonusNumber bonusNumber = getValidBonusNumberFromInput();
        winningNumbers = getValidWinningNumbersFromInput(winningNumber, bonusNumber);
    }

    private void generateWinningStatistics() {
        LottoResultsDTO resultDTO = createLottoResultsDTO();
        OutputView.displayAllLottosStatistics(resultDTO);
        OutputView.displayRateOfReturn(resultDTO);
    }

    private LottoResultsDTO createLottoResultsDTO() {
        List<LottoResults> lottoResults = lottos.calculateAllOfLottoResult(winningNumbers);
        Map<LottoResults, Integer> lottoStatistics = calculateLottoStatistics(lottoResults);
        long winningAmount = calculateTotalWinningAmount(lottoStatistics);
        return new LottoResultsDTO(lottoStatistics, winningAmount, buyAmount.getBuyAmount());
    }

    private Map<LottoResults, Integer> calculateLottoStatistics(List<LottoResults> lottoResults) {
        Map<LottoResults, Integer> lottoStatistics = new EnumMap<>(LottoResults.class);
        for (LottoResults result : lottoResults) {
            lottoStatistics.put(result, lottoStatistics.getOrDefault(result, 0) + 1);
        }
        return lottoStatistics;
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

    private BuyAmount getValidBuyAmountFromInput() {
        try {
            return new BuyAmount(InputView.getBuyAmountFromInput());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getValidBuyAmountFromInput();
        }
    }

    private WinningNumber getValidWinningNumberFromInput() {
        try {
            return new WinningNumber(InputView.getWinningNumberFromInput());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getValidWinningNumberFromInput();
        }
    }

    private BonusNumber getValidBonusNumberFromInput() {
        try {
            return new BonusNumber(InputView.getBonusNumberFromInput());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getValidBonusNumberFromInput();
        }
    }

    private WinningNumbers getValidWinningNumbersFromInput(WinningNumber winningNumber,
                                                           BonusNumber bonusNumber) {
        try {
            return new WinningNumbers(winningNumber, bonusNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            bonusNumber = getValidBonusNumberFromInput();
            return getValidWinningNumbersFromInput(winningNumber, bonusNumber);
        }
    }
}
