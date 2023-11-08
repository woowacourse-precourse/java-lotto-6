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

    public float calculateRate(int[] sameNumberCount, int price) {
        float rate = 0f;
        long sum = 0L;
        long[] prize = {0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000};

        for (int i = 0; i < 8; i++) {
            sum += sameNumberCount[i] * prize[i];
        }
        rate = sum / (float) price * 100;
        return rate;
    }

}