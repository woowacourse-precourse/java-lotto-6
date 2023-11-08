package model;

import domain.Lotto;
import java.util.List;

public class CheckLotto {

    public int[] checkLotto(List<Integer> answer, int bonusAnswer, List<Lotto> lottos) {
        int[] sameNumberCount = new int[8];      // 3, 4, 5, 6, 7
        for (Lotto lotto : lottos) {
            int count = sameNumberCount(answer, bonusAnswer, lotto);
            sameNumberCount[count]++;
        }
        return sameNumberCount;
    }

    public int sameNumberCount(List<Integer> answer, int bonusAnswer, Lotto lotto) {
        List<Integer> temp = lotto.getNumbers();
        int count = 0;
        for (int number : temp) {
            if (answer.contains(number)) {
                count++;
            }
        }

        if (count == 5) {
            if (temp.contains(bonusAnswer)) count += 2;
        }

        return count;
    }
}
