package lotto.Utils;

import java.util.List;
import lotto.Constants.IntConstants;
import lotto.Model.Lotto;
import lotto.Model.Player;

public class LottoResultCalculator {
    private LottoResultCalculator() {

    }

    public static void getResultList(List<Integer> results, int result, Lotto cpuSixNumber, Player playerLotto) {
        hitThree(results, result);
        hitFour(results, result);
        hitFive(results, result, cpuSixNumber.getNumbers(), playerLotto.getBonusNumber());
        hitFiveBonus(results, result, cpuSixNumber.getNumbers(), playerLotto.getBonusNumber());
        hitSix(results, result);
    }

    public static int countElement(List<Integer> cpuNumbers, List<Integer> playerNumbers) {
        int count = 0;
        for (Integer number : cpuNumbers) {
            if (playerNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static void hitThree(List<Integer> Lottoresult, int result) {
        if (result == IntConstants.THREE_HIT.getValue()) {
            int count = Lottoresult.get(IntConstants.FIRST_INDEX.getValue());
            ++count;
            Lottoresult.set(IntConstants.FIRST_INDEX.getValue(), count);
        }
    }

    private static void hitFour(List<Integer> Lottoresult, int result) {
        if (result == IntConstants.FOUR_HIT.getValue()) {
            int count = Lottoresult.get(IntConstants.SECOND_INDEX.getValue());
            ++count;
            Lottoresult.set(IntConstants.SECOND_INDEX.getValue(), count);
        }
    }

    private static void hitFive(List<Integer> Lottoresult, int result, List<Integer> cpuSixNumbers, int playerBonus) {
        if (result == IntConstants.FIVE_HIT.getValue() && !cpuSixNumbers.contains(playerBonus)) {
            int count = Lottoresult.get(IntConstants.THIRD_INDEX.getValue());
            ++count;
            Lottoresult.set(IntConstants.THIRD_INDEX.getValue(), count);
        }
    }

    private static void hitFiveBonus(List<Integer> Lottoresult, int result, List<Integer> cpuSixNumbers,
                                     int playerBonus) {
        if (result == IntConstants.FIVE_HIT.getValue() && cpuSixNumbers.contains(playerBonus)) {
            int count = Lottoresult.get(IntConstants.FORTH_INDEX.getValue());
            ++count;
            Lottoresult.set(IntConstants.FORTH_INDEX.getValue(), count);
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
