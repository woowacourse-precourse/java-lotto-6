package lotto.controller;

import java.util.List;


public class WinningStatistics {

    private static int[] result = {0, 0, 0, 0, 0, 0};
    public static int[] countLotto(List<Integer> myLotto, List<Integer> correctLotto, int bonus) {
        int count = calculateCount(myLotto, correctLotto);
        int bonusCount = calculateBonus(myLotto, bonus);
        correctThree(count);
        correctFour(count);
        correctFive(count,bonusCount);
        correctFiveAndBonus(count, bonusCount);
        correctSix(count);
        return result;
    }

    public static Integer calculateCount(List<Integer> list1, List<Integer> list2) {
        int count = 0;
        for (int num : list1) {
            if (list2.contains(num)) {
                count++;
            }
        }
        return count;
    }

    public static int calculateBonus(List<Integer> list1, int bonus) {
        if (list1.contains(bonus)) {
            return 1;
        }
        return 0;
    }

    public static void correctThree(int count) {
        if(count == 3){
            result[0] ++;
        }
    }

    public static void correctFour(int count) {
        if(count == 4){
            result[1] ++;
        }
    }

    public static void correctFive(int count, int bonus) {
        if(count == 5 && bonus==0){
            result[2] ++;
        }
    }

    public static void correctFiveAndBonus(int count, int bonus) {
        if(count == 5 && bonus==1){
            result[3] ++;
        }
    }

    public static void correctSix(int count) {
        if(count == 6){
            result[4] ++;
        }
    }

}
