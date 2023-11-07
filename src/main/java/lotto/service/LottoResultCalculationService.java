package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.LottoConstants;
import lotto.StringConstants;
import lotto.port.OutputPort;

public class LottoResultCalculationService {

    private final OutputPort outputPort;

    public LottoResultCalculationService(OutputPort outputPort) {
        this.outputPort =outputPort;
    }

    public Map<Integer, Integer> calculateMatchingCounts(List<List<Integer>> userLottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> matchingCounts = new HashMap<>();
        for (List<Integer> lottoNumbers : userLottoNumbers) {
            int count = countMatchedNumbers(lottoNumbers, winningNumbers);
            if (count == LottoConstants.WINNING_FIVE_NUMBER.getValue() && isMatchedBonusNumber(lottoNumbers, bonusNumber)) {
                count = LottoConstants.WINNING_FIVE_NUMBER_WITH_BONUS_NUMBER.getValue();
            }
            matchingCounts.put(count, matchingCounts.getOrDefault(count, 0) + 1);
        }
        return matchingCounts;
    }

    public int countMatchedNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean isMatchedBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public void printStatistics(Map<Integer, Integer> matchingCounts) {
        outputPort.printEmptyLine();
        outputPort.printLine(StringConstants.PRINT_STATISTICS_MESSAGE);
        outputPort.printLine(StringConstants.PRINT_STATISTICS_SEPARATOR);
        outputPort.printLine(StringConstants.PRINT_MATCH_COUNT_3 + matchingCounts.getOrDefault(3, 0) + "개");
        outputPort.printLine(StringConstants.PRINT_MATCH_COUNT_4 + matchingCounts.getOrDefault(4, 0) + "개");
        outputPort.printLine(StringConstants.PRINT_MATCH_COUNT_5 + matchingCounts.getOrDefault(5, 0) + "개");
        outputPort.printLine(StringConstants.PRINT_MATCH_COUNT_5_BONUS + matchingCounts.getOrDefault(7, 0) + "개");
        outputPort.printLine(StringConstants.PRINT_MATCH_COUNT_6 + matchingCounts.getOrDefault(6, 0) + "개");
    }

    public void printReturnRate(Map<Integer, Integer> matchingCounts, int lottoTicketsCount) {
        double returnRate = calculateReturnRate(matchingCounts, lottoTicketsCount);
        outputPort.printF(StringConstants.PRINT_RETURN_RATE_MESSAGE, returnRate);
    }

    public double calculateReturnRate(Map<Integer, Integer> matchingCounts, int lottoTicketsCount) {
        int totalPrize = 0;
        totalPrize += matchingCounts.getOrDefault(3, 0) * LottoConstants.PRIZE_MATCH_COUNT_3.getValue();
        totalPrize += matchingCounts.getOrDefault(4, 0) * LottoConstants.PRIZE_MATCH_COUNT_4.getValue();
        totalPrize += matchingCounts.getOrDefault(5, 0) * LottoConstants.PRIZE_MATCH_COUNT_5.getValue();
        totalPrize += matchingCounts.getOrDefault(7, 0) * LottoConstants.PRIZE_MATCH_COUNT_5_BONUS.getValue();
        totalPrize += matchingCounts.getOrDefault(6, 0) * LottoConstants.PRIZE_MATCH_COUNT_6.getValue();
        double purchaseAmount = lottoTicketsCount * LottoConstants.PRICE.getValue();
        return totalPrize / purchaseAmount * 100;
    }
}