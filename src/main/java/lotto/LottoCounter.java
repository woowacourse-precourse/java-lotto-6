package lotto;

import java.util.List;
import lotto.Constants.IntConstants;

public class LottoCounter {

    public int countElement(List<Integer> list1, List<Integer> list2) {
        int count = 0;
        for (Integer number : list1) {
            if (list2.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void hitThree(List<Integer> resultList, int result) {
        if (result == IntConstants.THREE_HIT.getValue()) {
            int count = resultList.get(0);
            ++count;
            resultList.set(0, count);
        }
    }

    public void hitFour(List<Integer> resultList, int result) {
        if (result == IntConstants.FOUR_HIT.getValue()) {
            int count = resultList.get(1);
            ++count;
            resultList.set(1, count);
        }
    }

    public void hitFive(List<Integer> resultList, int result, List<Integer> cpuSixNumbers, int playerBonus) {
        if (result == IntConstants.FIVE_HIT.getValue() && !cpuSixNumbers.contains(playerBonus)) {
            int count = resultList.get(2);
            ++count;
            resultList.set(2, count);
        }
    }

    public void hitFiveBonus(List<Integer> resultList, int result, List<Integer> cpuSixNumbers, int playerBonus) {
        if (result == IntConstants.FIVE_HIT.getValue() && cpuSixNumbers.contains(playerBonus)) {
            int count = resultList.get(3);
            ++count;
            resultList.set(3, count);
        }
    }

    public void hitSix(List<Integer> resultList, int result) {
        if (result == IntConstants.SIX_HIT.getValue()) {
            int count = resultList.get(4);
            ++count;
            resultList.set(4, count);
        }
    }
}
