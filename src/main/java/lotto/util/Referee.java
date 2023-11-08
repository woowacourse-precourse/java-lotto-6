package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

public class Referee {
    static final int[] MATCH_OUTCOME = {5000, 50000, 1500000, 200000000, 30000000};

    public static int[] compareToLottos(List<Lotto> lottos, Lotto answer, int bonus) {
        int[] result = new int[5]; // 크기 5
        for (Lotto lotto : lottos) {
            int[] count = compareToLotto(lotto, answer, bonus);
            updateResult(result, count);
        }
        return result;
    }

    private static void updateResult(int[] result, int[] count) {
        int same = count[0] + count[1];
        int bonus = count[1];
        int idx = same-3;
        if(idx < 0) {
            return;
        }
        if(same == 5 && bonus == 1) {
            result[idx+2]++;
            return;
        }
        result[idx]++;
    }

    private static int[] compareToLotto(Lotto lotto, Lotto answer, int bonus) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int[] count = {0, 0};
        for (Integer number : lottoNumbers) {
            int idx = compareTo(number, answer, bonus)-1;
            if(idx<0) {
                continue;
            }
            count[idx]++;
        }
        return count;
    }

    private static Integer compareTo(Integer number, Lotto answer, int bonus) {
        List<Integer> answerNumbers = answer.getNumbers();
        if (number == bonus) {
            return 2; // bonus
        }
        for (int i = 0; i < answerNumbers.size(); i++) {
            if (answerNumbers.get(i) == number) {
                return 1; // true
            }
        }
        return 0; // false
    }

    public static double calculateIncome(int[] winning, int purchaseCount) {
        double income = 0;
        double money = purchaseCount * 1000; // 처음 투자비용
        for (int i = 0; i < winning.length; i++) {
            if (winning[i] > 0) {
                income += winning[i] * MATCH_OUTCOME[i]; // 순투자수익
            }
        }
        income = income / money;
        income *= 100;
        income = Math.round(income * 10) / 10.0; // 소수점 둘째자리에서 반올림 과정 : 64.20*10 => 642.0 => round => 642 => 642/10.0 => 64.2
        return income;
    }
}
