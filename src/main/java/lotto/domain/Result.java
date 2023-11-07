package lotto.domain;

import static lotto.domain.PurchaseAmount.getPurchaseAmount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private static int countMatchSix;
    private static int countMatchFiveWithBonus;
    private static int countMatchFive;
    private static int countMatchFour;
    private static int countMatchThree;

    public static Map<String, Object> calculateResult(List<Lotto> lottoTickets, List<Integer> winningNumbers,
                                                      int bonusNumber) {
        Map<String, Object> result = new HashMap<>();

        int totalPrize = calculateTotalPrize(lottoTickets, winningNumbers, bonusNumber);
        double profitRate = calculateProfitRate(totalPrize);

        result.put("1등", countMatchSix);
        result.put("2등", countMatchFiveWithBonus);
        result.put("3등", countMatchFive);
        result.put("4등", countMatchFour);
        result.put("5등", countMatchThree);
        result.put("총 수익률", profitRate);

        return result;
    }

    private static int calculateTotalPrize(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        int totalPrize = 0;

        for (Lotto lottoTicket : lottoTickets) {
            int matchCount = countMatchingNumbers(lottoTicket.getNumbers(), winningNumbers);
            boolean hasBonusNumber = lottoTicket.getNumbers().contains(bonusNumber);

            totalPrize += calculatePrizeForTicket(matchCount, hasBonusNumber);
            updateCounters(matchCount, hasBonusNumber);
        }

        return totalPrize;
    }

    private static int calculatePrizeForTicket(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 6) {
            return 2_000_000_000;
        }
        if (matchCount == 5 && hasBonusNumber) {
            return 30_000_000;
        }
        if (matchCount == 5 && !hasBonusNumber) {
            return 1_500_000;
        }
        if (matchCount == 4) {
            return 50_000;
        }
        if (matchCount == 3) {
            return 5_000;
        }
        return 0;
    }

    private static void updateCounters(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 6) {
            countMatchSix++;
        }
        if (matchCount == 5 && hasBonusNumber) {
            countMatchFiveWithBonus++;
        }
        if (matchCount == 5 && !hasBonusNumber) {
            countMatchFive++;
        }
        if (matchCount == 4) {
            countMatchFour++;
        }
        if (matchCount == 3) {
            countMatchThree++;
        }
    }

    private static int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static double calculateProfitRate(int totalPrize) {
        return ((double) totalPrize / (double) getPurchaseAmount()) * 100;
    }
}
