package lotto.domain;

import lotto.constants.Rank;
import lotto.model.Lotto;

import java.util.Comparator;
import java.util.List;

public class Controller {



    public static void sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }



    public static Integer countMatchingNumberBetween(List<Integer> winningNumbers, Integer lotteryNumber) {
        int matchingCount = 0;
        for (Integer winningNumber : winningNumbers) {
            if (lotteryNumber.equals(winningNumber)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    public static void fillLotteryRankList(List<Rank> lotteryRankList, List<Integer> matchingCountList) {
        for (Integer matchingNumberCount : matchingCountList) {
            if (matchingNumberCount.equals(6)) {
                lotteryRankList.add(Rank.FIRST);
            }
            if (matchingNumberCount.equals(5)) {
                lotteryRankList.add(Rank.THIRD);
            }
            if (matchingNumberCount.equals(4)) {
                lotteryRankList.add(Rank.FOURTH);
            }
            if (matchingNumberCount.equals(3)) {
                lotteryRankList.add(Rank.FIFTH);
            }
            if (matchingNumberCount < 3) {
                lotteryRankList.add(Rank.FAIL);
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

    public static void changeRankByBonusNumber(List<Rank> lotteryRankList, boolean bonusFlag, int index) {
        if (bonusFlag) {
            lotteryRankList.set(index, Rank.SECOND);
        }
    }

    public static void fillMatchingCountList(
            List<Lotto> lottoList,
            List<Integer> winningNumbers,
            List<Integer> matchingCountList) {
        for (Lotto lotto : lottoList) {
            int countTemp = 0;
            List<Integer> lottoNumbers = lotto.getNumbers();
            for (Integer lottoNumber : lottoNumbers) {
                countTemp += Controller.countMatchingNumberBetween(winningNumbers, lottoNumber);
            }
            matchingCountList.add(countTemp);
        }
    }
}


