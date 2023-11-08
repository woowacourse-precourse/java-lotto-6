package model;

import domain.Lotto;
import java.util.List;

public class CheckLotto {

    private final int LOTTO_COUNT_NUMBER = 8;     // 0, 1, 2, 3, 4, 5, 6, 7(5 + bonus)

    public int[] checkLotto(List<Integer> answer, int bonusAnswer, List<Lotto> lottos) {
        int[] sameNumberCount = new int[LOTTO_COUNT_NUMBER];
        for (Lotto lotto : lottos) {
            int count = sameNumberCount(answer, bonusAnswer, lotto.getNumbers());
            sameNumberCount[count]++;
        }
        return sameNumberCount;
    }

    public int sameNumberCount(List<Integer> answer, int bonusAnswer, List<Integer> lotto) {
        int count = 0;
        for (int number : lotto) {
            if (answer.contains(number)) {
                count++;
            }
        }
        return count + checkBonusBall(count, bonusAnswer, lotto);
    }

    public int checkBonusBall(int count, int bonus, List<Integer> lotto) {
        if (count == 5 && lotto.contains(bonus)) {
            return 2;
        }
        return 0;
    }
}
