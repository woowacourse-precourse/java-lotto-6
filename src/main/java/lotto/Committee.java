package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Set;

public class Committee {
    private static Committee committee = new Committee();

    private Committee() {

    }

    public static Committee getInstance() {
        return committee;
    }

    public int[] calculateResult(List<Integer>[] issueNumbers, Lotto lotto, int bonusNumber) {
        int sameNumberCount[] = new int[8];

        for (int i = 0; i < issueNumbers.length; i++) {
            int count = checkSameNumbers(issueNumbers, lotto, i);
            sameNumberCount[count]++;
            if (issueNumbers[i].contains(bonusNumber) && count == 5) {
                sameNumberCount[7]++; //5개 일치, 보너스 볼 일치하는 경우
                sameNumberCount[5]--;
            }
        }
        return sameNumberCount;
    }

    private int checkSameNumbers(List<Integer>[] issueNumbers, Lotto lotto, int i) {
        int count = 0;
        for (int j = 0; j < 6; j++) {
            if (lotto.containsNum(issueNumbers[i].get(j))) {
                count++;
            }
        }
        return count;
    }

}