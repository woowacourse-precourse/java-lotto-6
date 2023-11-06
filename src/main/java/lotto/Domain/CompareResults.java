package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CompareResults {

    public static int[] compareLottoResults(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchingCounts = new int[8];

        for (Lotto lotto : lottoList) {
            int matchingCount = countMatchingNumber(lotto, winningNumbers);
            boolean bonusBall = lotto.contains(bonusNumber);

            matchingCounts = totalMatchingCounts(matchingCounts, matchingCount, bonusBall);
        }

        return matchingCounts;
    }

    private static int countMatchingNumber(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static boolean bonusMatching(List<Integer> winningNumbers, boolean bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            return true;
        }

        return false;
    }

    public static int[] totalMatchingCounts(int[] matchingCounts, int matchingCount, boolean bonusMatch) {
        if (bonusMatch == true)
            if(matchingCount == 5)
            {
                matchingCounts[7]++;
            }

        else if (bonusMatch == false)
            {
                for(int i = 0; i <= 6; i++)
                {
                    if(matchingCounts[i] == matchingCount)
                    {
                        matchingCounts[i]++;
                    }
                }
            }
        return matchingCounts;
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

    public static double calculateProfitRate(long totalPrizeAmount, long totalPurchaseAmount) {
        return (double) totalPrizeAmount / totalPurchaseAmount;
    }
}
