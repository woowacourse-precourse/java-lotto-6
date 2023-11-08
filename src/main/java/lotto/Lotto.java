package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static List<Integer> randomNumbers;
    private static List<List<Integer>> randomNumberList = new ArrayList<List<Integer>>();
    private static final int FIRST = 6;
    private static final int SECOND = 5;
    private static final int THIRD = 5;
    private static final int FOURTH = 4;
    private static final int FIFTH = 3;

    private static int FIRST_NUM = 0;
    private static int SECOND_NUM = 0;
    private static int THIRD_NUM = 0;
    private static int FOURTH_NUM = 0;
    private static int FIFTH_NUM = 0;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void publish(int purchaseNum) {
        for (int i = 0; i < purchaseNum; i++) {
            randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            randomNumbers.sort(Comparator.naturalOrder());
            System.out.println(randomNumbers);
            randomNumberList.add(randomNumbers);
        }
    }

    public static void compare(List<Integer> winningNums) {
        Integer bonusNum = winningNums.remove(winningNums.size() - 1);
        boolean bonus = false;
        for (List<Integer> random : randomNumberList) {
            int num = 0;
            for (Integer i : random) {
                if (winningNums.contains(i)) num++;
                else if (i == bonusNum) {
                    num++;
                    bonus = true;
                }
            }
            check(num, bonus);
        }
        output();
    }

    public static void check(int num, boolean bonus) {
        if (num == FIRST) FIRST_NUM++;
        else if (num == SECOND && bonus == true) SECOND_NUM++;
        else if (num == THIRD) THIRD_NUM++;
        else if (num == FOURTH) FOURTH_NUM++;
        else if (num == FIFTH) FIFTH_NUM++;
    }

    public static void output() {
        System.out.println("3개 일치 (5,000원) - " + FIFTH_NUM);
        System.out.println("4개 일치 (50,000원) - " + FOURTH_NUM);
        System.out.println("5개 일치 (1,500,000원) - " + THIRD_NUM);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + SECOND_NUM);
        System.out.println("6개 일치 (2,000,000,000원) - " + FIRST_NUM);
    }

    public static float revenue(int money) {
        return (5000 * FIFTH_NUM
                + 50000 * FOURTH_NUM
                + 1500000 * THIRD_NUM
                + 10000000 * SECOND_NUM
                + 30000000 * SECOND_NUM
                + 2000000000 * FIRST_NUM) / money;
    }
}
