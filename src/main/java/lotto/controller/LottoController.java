package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoController {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LENGTH = 6;

    public static List<Lotto> generateTicket(int number) {
        List<Lotto> ticket = new ArrayList<Lotto>();
        for (int i = 0; i < number / 1000; i++) {
            ticket.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LENGTH)));
        }
        return ticket;
    }

    public static List<Double> determine(List<Lotto> ticket, List<Integer> winningNum, int bonusNum) {
        List<Double> result = new ArrayList<Double>();
        for (Lotto lotto : ticket) {
            result.add(searchSameNum(lotto.getNumbers(), winningNum, bonusNum));
        }
        return result;
    }

    private static double searchSameNum(List<Integer> numbers, List<Integer> winningNum, int bonusNum) {
        double count = 0;
        for (Integer number : numbers) {
            if (winningNum.contains(number)) {
                count++;
            }
        }
        if (count == 5 && isContainBonus(numbers, bonusNum)) {
            count += 0.5;
        }
        return count;
    }

    static boolean isContainBonus(List<Integer> numbers, int bonusNum) {
        boolean result = false;
        if (numbers.contains(bonusNum)) {
            result = true;
        }
        return result;
    }

    public static int[] countResult(List<Double> results) {
        int[] count = { 0, 0, 0, 0, 0 };
        for (Double result : results) {
            if (result == 3) {
                ++count[0];
            } else if (result == 4) {
                ++count[1];
            } else if (result == 5) {
                ++count[2];
            } else if (result == 5.5) {
                ++count[3];
            } else if (result == 6) {
                ++count[4];
            }
        }
        return count;
    }

    public static double calculateReturn(List<Double> results, int amount) {
        double money = 0;
        for (Double result : results) {
            if (result == 3) {
                money += 5000;
            } else if (result == 4) {
                money += 50000;
            } else if (result == 5) {
                money += 1500000;
            } else if (result == 5.5) {
                money += 30000000;
            } else if (result == 6) {
                money += 2000000000;
            }
        }
        return (money / amount) * 100.00;
    }
}
