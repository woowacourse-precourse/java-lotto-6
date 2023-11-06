package lotto.domain;

import lotto.constants.Rank;
import lotto.model.Lotto;

import java.util.Comparator;
import java.util.List;

public class Controller {

    static final Integer LOTTERY_PRICE = 1_000;

    public static void sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
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

    public static void fillMatchingNumberCountList(
            List<Lotto> lottoList,
            List<Integer> winningNumbers,
            List<Integer> matchingNumberCountList) {
        for (Lotto lotto : lottoList) {
            int countTemp = 0;
            List<Integer> lottoNumbers = lotto.getNumbers();
            for (Integer lottoNumber : lottoNumbers) {
                countTemp += Controller.countMatchingNumbersByLotteryNumber(winningNumbers, lottoNumber);
            }
            matchingNumberCountList.add(countTemp);
        }
    }
}


