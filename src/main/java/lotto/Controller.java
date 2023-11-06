package lotto;

import java.util.Collections;
import java.util.List;

public class Controller {

    static final Integer LOTTERY_PRICE = 1_000;

    public static Integer calculateLotteryCount(Integer budget) {
        return budget / LOTTERY_PRICE;
    }

    public static Integer countMatchingNumbersByLotteryNumber(List<Integer> winningNumbers, Integer lotteryNumber) {
        int matchingCount = 0;
        for (Integer winningNumber : winningNumbers) {
            if (lotteryNumber.equals(winningNumber)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    public static void fillRankList(List<Rank> rankList, List<Integer> matchingNumberCountList) {
        for (Integer matchingNumberCount : matchingNumberCountList) {
            if (matchingNumberCount.equals(6)) {
                rankList.add(Rank.FIRST);
            }
            if (matchingNumberCount.equals(5)) {
                rankList.add(Rank.THIRD);
            }
            if (matchingNumberCount.equals(4)) {
                rankList.add(Rank.FOURTH);
            }
            if (matchingNumberCount.equals(3)) {
                rankList.add(Rank.FIFTH);
            }
            if (matchingNumberCount < 3) {
                rankList.add(Rank.FAIL);
            }
        }
    }

    public static boolean bonusNumberFlag(List<Integer> lotteryNumbers, Integer bonusNumber) {
        for (Integer lotteryNumber : lotteryNumbers) {
            if (lotteryNumber.equals(bonusNumber)) {
                return true;
            }
        }
        return false;
    }

    public static void changeRankByBonusNumber(List<Rank> rankList, boolean bonusFlag, int index) {
        if (bonusFlag) {
            rankList.set(index, Rank.SECOND);
        }
    }

    public static Integer calculateTotalPrize(List<Rank> rankList) {
        Integer totalPrize = 0;
        for (Rank rank : Rank.values()) {
            int rankFrequency = Collections.frequency(rankList, rank);
            totalPrize += rank.calculatePrizeByRank(rankFrequency);
        }
        return totalPrize;
    }

    public static Double calculatePricePrizeRatio(Integer totalPrize, Integer price) {
        return (double) totalPrize / price * 100;
    }

    public static boolean validateUserInputIsOnlyNumbers(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            if (Validator.isNumberOnly(winningNumber)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateUserInputNumberIsOutOfValidRange(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (Validator.isNumberOnValidRange(winningNumber)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateUserInputNumberIsDuplicate(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (Validator.isWinningNumberDuplicate(winningNumber, winningNumbers)) {
                return true;
            }
        }
        return false;
    }
}


