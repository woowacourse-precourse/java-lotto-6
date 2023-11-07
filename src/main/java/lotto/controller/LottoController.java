package lotto.controller;

import static lotto.utils.validator.LottoNumberValidator.validateDuplicate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.BuyAmount;
import lotto.domain.Lotto;
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
        winningStatistics();
    }

    private void buyLotto() {
        buyAmount = createBuyAmount();
        List<Lotto> lottoNumbers = lottoGenerator.generateLottos(buyAmount.getAbleToBuyCount());
        lottos = new Lottos(lottoNumbers);
        OutputView.displayAllLottos(lottos.toLottosDTO());
    }

    private void drawLotto() {
        WinningNumber winningNumber = createWinningNumber();
        BonusNumber bonusNumber = createBonusNumber();
        winningNumbers = createWinningNumbers(winningNumber, bonusNumber);
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
        return new LottoResultsDTO(lottoStatistics, winningAmount, buyAmount.getBuyAmount());
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

    private BuyAmount createBuyAmount() {
        while (true) {
            try {
                return new BuyAmount(InputView.getBuyAmountFromInput());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private WinningNumber createWinningNumber() {
        while (true) {
            try {
                return new WinningNumber(InputView.getWinningNumberFromInput());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private BonusNumber createBonusNumber() {
        while (true) {
            try {
                return new BonusNumber(InputView.getBonusNumberFromInput());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private WinningNumbers createWinningNumbers(WinningNumber winningNumber,
                                                BonusNumber bonusNumber) {
        while (true) {
            try {
                validateDuplicate(winningNumber, bonusNumber);
                return new WinningNumbers(winningNumber, bonusNumber);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                bonusNumber = createBonusNumber();
            }
        }
    }
}
