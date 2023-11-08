package lotto.service;

import java.util.List;
import lotto.model.Prize;

public class LotteryStatistics {
    public static int countMatchedNumbers(List<Integer> userLotto, List<Integer> winningNums) {
        int count = 0;

        for (int i = 0; i < winningNums.size() - 1; i++) {
            if (userLotto.contains(winningNums.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static int calculateEarnings(int matchedCount, boolean isBonusMatched) {
        Prize prize = determinePrize(matchedCount, isBonusMatched);
        return prize.getPrizeMoney();
    }

    public static int calculateTotalEarnings(List<List<Integer>> userLottoList, List<Integer> winningNums) {
        int totalEarnings = 0;
        for (List<Integer> userLotto : userLottoList) {
            int matchedCount = LotteryStatistics.countMatchedNumbers(userLotto, winningNums);
            boolean isBonusMatched = userLotto.contains(winningNums.get(winningNums.size() - 1));

            int earnings = LotteryStatistics.calculateEarnings(matchedCount, isBonusMatched);
            totalEarnings += earnings;
        }
        return totalEarnings;
    }

    public static int[] countWinningCounts(List<List<Integer>> userLottoList, List<Integer> winningNums) {
        int[] winningCounts = new int[5];

        for (List<Integer> userLotto : userLottoList) {
            int matchedCount = LotteryStatistics.countMatchedNumbers(userLotto, winningNums);
            if (matchedCount >= 3) {
                winningCounts[matchedCount - 3]++;
            }
        }
        return winningCounts;
    }

    public static Prize determinePrize(int matchedCount, boolean isBonusMatched) {
        if (matchedCount == 6) {
            return Prize.FIRST;
        } else if (matchedCount == 5 && isBonusMatched) {
            return Prize.SECOND;
        } else if (matchedCount == 5) {
            return Prize.THIRD;
        } else if (matchedCount == 4) {
            return Prize.FOURTH;
        } else if (matchedCount == 3) {
            return Prize.FIFTH;
        }
        return Prize.NONE;
    }
}
