package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.LottoConstants;

public class LottoResultCalculationService {
    public Map<Integer, Integer> calculateMatchingCounts(List<List<Integer>> userLottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> matchingCounts = new HashMap<>();
        for (List<Integer> lottoNumbers : userLottoNumbers) {
            int count = countMatchedNumbers(lottoNumbers, winningNumbers);
            if (count == 5 && isMatchedBonusNumber(lottoNumbers, bonusNumber)) {
                count = 7;
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
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchingCounts.getOrDefault(3, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + matchingCounts.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchingCounts.getOrDefault(5, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchingCounts.getOrDefault(7, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchingCounts.getOrDefault(6, 0) + "개");
    }

    public void printReturnRate(Map<Integer, Integer> matchingCounts, int lottoTicketsCount) {
        double returnRate = calculateReturnRate(matchingCounts, lottoTicketsCount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }

    public double calculateReturnRate(Map<Integer, Integer> matchingCounts, int lottoTicketsCount) {
        int totalPrize = 0;
        totalPrize += matchingCounts.getOrDefault(3, 0) * 5000;
        totalPrize += matchingCounts.getOrDefault(4, 0) * 50000;
        totalPrize += matchingCounts.getOrDefault(5, 0) * 1500000;
        totalPrize += matchingCounts.getOrDefault(7, 0) * 30000000;
        totalPrize += matchingCounts.getOrDefault(6, 0) * 2000000000;
        double purchaseAmount = lottoTicketsCount * LottoConstants.PRICE.getValue();
        return totalPrize / purchaseAmount * 100;
    }
}