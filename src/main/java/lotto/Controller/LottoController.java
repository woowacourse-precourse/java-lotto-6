package lotto.Controller;

import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoNumbers;
import lotto.Domain.LottoResult;
import lotto.Domain.Money;
import lotto.Service.LottoService;
import lotto.Util.LottoConverter;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoController {
    private static final int STANDARD_UNIT = 1000;
    private static final int PRIZE_THREE_MATCH = 5000;
    private static final int PRIZE_FOUR_MATCH = 50000;
    private static final int PRIZE_FIVE_MATCH = 1500000;
    private static final int PRIZE_FIVE_MATCH_WITH_BONUS = 30000000;
    private static final int PRIZE_SIX_MATCH = 2000000000;
    private static final double PERCENTAGE = 100.0;
    private final LottoService lottoService = new LottoService();

    public void play() {
        int purchaseAmount = getPurchaseAmount();

        int lottoCount = purchaseAmount / STANDARD_UNIT;
        OutputView.returnLottoCount(lottoCount);

        List<LottoNumbers> lottoTickets = lottoService.generateLottoNumbers(new Money(purchaseAmount));
        printLottoNumbers(lottoTickets);

        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber();

        printLottoResultAndReturn(purchaseAmount, lottoTickets, winningLotto, bonusNumber);
    }

    private int getPurchaseAmount() {
        String purchaseAmountInput = InputView.inputPurchaseAmount();
        return Integer.parseInt(purchaseAmountInput);
    }

    private void printLottoNumbers(List<LottoNumbers> lottoTickets) {
        for (LottoNumbers lottoNumbers : lottoTickets) {
            OutputView.printLottoNumbers(lottoNumbers.getNumbers());
        }
    }

    private Lotto getWinningLotto() {
        String winningNumberInput = InputView.inputWinningNumber();
        List<Integer> winningNumbers = LottoConverter.convertStringToNumbers(winningNumberInput);
        return new Lotto(winningNumbers);
    }

    private int getBonusNumber() {
        String bonusNumberInput = InputView.inputBonusNumber();
        return Integer.parseInt(bonusNumberInput);
    }

    private void printLottoResultAndReturn(int purchaseAmount, List<LottoNumbers> lottoTickets, Lotto winningLotto,
                                           int bonusNumber) {
        int[] matchCounts = new int[5];

        for (LottoNumbers lottoNumbers : lottoTickets) {
            calculateLottoNumbers(matchCounts, lottoNumbers, purchaseAmount, winningLotto, bonusNumber);
        }

        OutputView.printWinningStatistics(matchCounts[0], matchCounts[1], matchCounts[2], matchCounts[3],
                matchCounts[4]);

        double rateOfReturn = calculateRateOfReturn(matchCounts, purchaseAmount);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    private void calculateLottoNumbers(int[] matchCounts, LottoNumbers lottoNumbers, int purchaseAmount,
                                       Lotto winningLotto,
                                       int bonusNumber) {
        List<LottoResult> results = lottoService.playLottoGame(new Money(purchaseAmount), lottoNumbers, winningLotto,
                bonusNumber);

        boolean[] matchResults = validateMatches(results);

        for (int i = 0; i < matchCounts.length; i++) {
            if (matchResults[i]) {
                matchCounts[i]++;
            }
        }
    }

    private boolean[] validateMatches(List<LottoResult> results) {
        boolean[] matchResults = new boolean[5];

        for (LottoResult result : results) {
            int matchedNumbers = result.getMatchedNumbers();
            boolean matchedBonus = result.isMatchedBonusNumber();

            if (matchedNumbers == 3 && !matchedBonus) {
                matchResults[0] = true;
            }
            if (matchedNumbers == 4 && !matchedBonus) {
                matchResults[1] = true;
            }
            if (matchedNumbers == 5 && !matchedBonus) {
                matchResults[2] = true;
            }
            if (matchedNumbers == 5 && matchedBonus) {
                matchResults[3] = true;
            }
            if (matchedNumbers == 6) {
                matchResults[4] = true;
            }
        }

        return matchResults;
    }

    private double calculateRateOfReturn(int[] matchCounts, int purchaseAmount) {
        int[] prizeAmounts = {PRIZE_THREE_MATCH, PRIZE_FOUR_MATCH, PRIZE_FIVE_MATCH, PRIZE_FIVE_MATCH_WITH_BONUS,
                PRIZE_SIX_MATCH};
        double totalPrizeAmount = 0;

        for (int i = 0; i < matchCounts.length; i++) {
            totalPrizeAmount += matchCounts[i] * prizeAmounts[i];
        }

        return (totalPrizeAmount / purchaseAmount) * PERCENTAGE;
    }
}