package lotto;

import java.util.List;
import lotto.Constants.IntConstants;

public class LottoCounter {

    public static void getResultList(List<Integer> resultList, int result, Lotto cpuSixNumber, Player playerLotto) {
        hitThree(resultList, result);
        hitFour(resultList, result);
        hitFive(resultList, result, cpuSixNumber.getNumbers(), playerLotto.getBonusNumber());
        hitFiveBonus(resultList, result, cpuSixNumber.getNumbers(), playerLotto.getBonusNumber());
        hitSix(resultList, result);
    }

    public static int countElement(List<Integer> list1, List<Integer> list2) {
        int count = 0;
        for (Integer number : list1) {
            if (list2.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static void hitThree(List<Integer> resultList, int result) {
        if (result == IntConstants.THREE_HIT.getValue()) {
            int count = resultList.get(IntConstants.FIRST_INDEX.getValue());
            ++count;
            resultList.set(IntConstants.FIRST_INDEX.getValue(), count);
        }
    }

    private static void hitFour(List<Integer> resultList, int result) {
        if (result == IntConstants.FOUR_HIT.getValue()) {
            int count = resultList.get(IntConstants.SECOND_INDEX.getValue());
            ++count;
            resultList.set(IntConstants.SECOND_INDEX.getValue(), count);
        }
    }

    private static void hitFive(List<Integer> resultList, int result, List<Integer> cpuSixNumbers, int playerBonus) {
        if (result == IntConstants.FIVE_HIT.getValue() && !cpuSixNumbers.contains(playerBonus)) {
            int count = resultList.get(IntConstants.THREE_HIT.getValue());
            ++count;
            resultList.set(IntConstants.THREE_HIT.getValue(), count);
        }
    }

    private static void hitFiveBonus(List<Integer> resultList, int result, List<Integer> cpuSixNumbers,
                                     int playerBonus) {
        if (result == IntConstants.FIVE_HIT.getValue() && cpuSixNumbers.contains(playerBonus)) {
            int count = resultList.get(IntConstants.FORTH_INDEX.getValue());
            ++count;
            resultList.set(IntConstants.FORTH_INDEX.getValue(), count);
        }
    }

    private static void hitSix(List<Integer> resultList, int result) {
        if (result == IntConstants.SIX_HIT.getValue()) {
            int count = resultList.get(IntConstants.FIFTH_INDEX.getValue());
            ++count;
            resultList.set(IntConstants.FIFTH_INDEX.getValue(), count);
        }
    }
}
