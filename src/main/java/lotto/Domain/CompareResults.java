package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CompareResults {

    public static void compareLottoResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {

        int[] matchingCounts = new int[7];

        for (Lotto lotto : purchasedLottos) {
            int matchingCount = countMatchingNumbers(lotto, winningNumbers);
            boolean bonusMatch = lotto.contains(bonusNumber);

            totalMatchingCounts(matchingCounts, matchingCount, bonusMatch);
        }
    }

    private static int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static int totalMatchingCounts(int[] matchingCounts, int matchingCount, boolean bonusMatch) {
        if (matchingCount == 6) {
            matchingCounts[6]++;
            return 6;
        }

        if (matchingCount == 5 && bonusMatch) {
            matchingCounts[5]++;
            return 5;
        }

        matchingCounts[matchingCount]++;
        return matchingCount;
    }

    public static long calculatePrizeAmount(int[] matchingCounts) {
        long prizeAmount = 0;

        if (matchingCounts[6] > 0) {
            prizeAmount += matchingCounts[6] * 2_000_000_000L;
        }
        if (matchingCounts[5] > 0 && matchingCounts[5] == 1 && matchingCounts[6] == 0) {
            prizeAmount += matchingCounts[5] * 30_000_000L;
        }
        if (matchingCounts[5] > 1 && matchingCounts[6] == 0) {
            prizeAmount += matchingCounts[5] * 1_500_000L;
        }
        if (matchingCounts[4] > 0 && matchingCounts[6] == 0) {
            prizeAmount += matchingCounts[4] * 50_000L;
        }
        if (matchingCounts[3] > 0 && matchingCounts[6] == 0) {
            prizeAmount += matchingCounts[3] * 5_000L;
        }
        return prizeAmount;
    }
}
