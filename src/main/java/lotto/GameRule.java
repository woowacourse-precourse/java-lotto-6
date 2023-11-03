package lotto;

import java.util.ArrayList;
import java.util.List;

public class GameRule {
    public List<Integer> calculateResult(List<Lotto> cpuLottos, Lotto playerLotto, int bonusNumber) {
        List<Integer> resultList = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (Lotto cpuLotto : cpuLottos) {
            int result = countElement(cpuLotto.getNumbers(), playerLotto.getNumbers());
            hitThree(resultList, result);
            hitFour(resultList, result);
            hitFive(resultList, result);
            hitFiveBonus(resultList, result, bonusNumber);
            hitSix(resultList, result);
        }
        return resultList;
    }

    public double calculateProfit(int inputMoney,List<Integer> gameResult) {
        int income = 0;
        for (Integer i : gameResult) {
            income += i *
        }
        return
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

    private static boolean checkBouns(List<Integer> list1, int bonus) {
        return list1.contains(bonus);
    }

    private static void hitThree(List<Integer> resultList, int result) {
        int count = 0;
        if (result == IntConstants.THREE_HIT.getValue()) {
            ++count;
        }
        resultList.add(0, count);
    }

    private static void hitFour(List<Integer> resultList, int result) {
        int count = 0;
        if (result == IntConstants.FOUR_HIT.getValue()) {
            ++count;
        }
        resultList.add(1, count);
    }

    private static void hitFive(List<Integer> resultList, int result) {
        int count = 0;
        if (result == IntConstants.FIVE_HIT.getValue()) {
            ++count;
        }
        resultList.add(2, count);
    }

    private static void hitFiveBonus(List<Integer> resultList, int result, int bouns) {
        int count = 0;
        if (result == IntConstants.FIVE_HIT.getValue() && checkBouns(resultList, bouns)) {
            ++count;
        }
        resultList.add(3, count);
    }

    private static void hitSix(List<Integer> resultList, int result) {
        int count = 0;
        if (result == IntConstants.SIX_HIT.getValue()) {
            ++count;
        }
        resultList.add(4, count);
    }
}
