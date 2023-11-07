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

    public static void fillRanks(List<Rank> lotteryRanks, List<Integer> matchingCounts) {
        for (Integer matchingNumberCount : matchingCounts) {
            if (matchingNumberCount.equals(6)) {
                lotteryRanks.add(Rank.FIRST);
            }
            if (matchingNumberCount.equals(5)) {
                lotteryRanks.add(Rank.THIRD);
            }
            if (matchingNumberCount.equals(4)) {
                lotteryRanks.add(Rank.FOURTH);
            }
            if (matchingNumberCount.equals(3)) {
                lotteryRanks.add(Rank.FIFTH);
            }
            if (matchingNumberCount < 3) {
                lotteryRanks.add(Rank.FAIL);
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

    public static void changeRankByBonusNumber(List<Rank> lotteryRanks, boolean bonusFlag, int index) {
        if (bonusFlag) {
            lotteryRanks.set(index, Rank.SECOND);
        }
    }

    public static void fillMatchingCounts(
            List<Lotto> lottos,
            List<Integer> winningNumbers,
            List<Integer> matchingCounts) {
        for (Lotto lotto : lottos) {
            int countTemp = 0;
            List<Integer> lottoNumbers = lotto.getNumbers();
            for (Integer lottoNumber : lottoNumbers) {
                countTemp += Controller.countMatchingNumberBetween(winningNumbers, lottoNumber);
            }
            matchingCounts.add(countTemp);
        }
    }
}


