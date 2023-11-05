package lotto;

import java.util.List;
import lotto.Constants.IntConstants;

public class LottoCounter {

    public void getResultList(List<Integer> resultList, int result, Lotto cpuSixNumber, Player playerLotto) {
        hitThree(resultList, result);
        hitFour(resultList, result);
        hitFive(resultList, result, cpuSixNumber.getNumbers(), playerLotto.getBonusNumber());
        hitFiveBonus(resultList, result, cpuSixNumber.getNumbers(), playerLotto.getBonusNumber());
        hitSix(resultList, result);
    }

    public int countElement(List<Integer> list1, List<Integer> list2) {
        int count = 0;
        for (Integer number : list1) {
            if (list2.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void hitThree(List<Integer> resultList, int result) {
        if (result == IntConstants.THREE_HIT.getValue()) {
            int count = resultList.get(0);
            ++count;
            resultList.set(0, count);
        }
    }

    private void hitFour(List<Integer> resultList, int result) {
        if (result == IntConstants.FOUR_HIT.getValue()) {
            int count = resultList.get(1);
            ++count;
            resultList.set(1, count);
        }
    }

    private void hitFive(List<Integer> resultList, int result, List<Integer> cpuSixNumbers, int playerBonus) {
        if (result == IntConstants.FIVE_HIT.getValue() && !cpuSixNumbers.contains(playerBonus)) {
            int count = resultList.get(2);
            ++count;
            resultList.set(2, count);
        }
    }

    private void hitFiveBonus(List<Integer> resultList, int result, List<Integer> cpuSixNumbers, int playerBonus) {
        if (result == IntConstants.FIVE_HIT.getValue() && cpuSixNumbers.contains(playerBonus)) {
            int count = resultList.get(3);
            ++count;
            resultList.set(3, count);
        }
    }

    private void hitSix(List<Integer> resultList, int result) {
        if (result == IntConstants.SIX_HIT.getValue()) {
            int count = resultList.get(4);
            ++count;
            resultList.set(4, count);
        }
    }
}
