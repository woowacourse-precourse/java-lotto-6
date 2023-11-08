package lotto;

import java.util.List;

public class Committee {
    private static Committee committee = new Committee();
    private static int ARRAY_SIZE = 8;
    private static int BONUS_INDEX = 7;
    private static int FIVE_INDEX = 5;
    static final int NUM_OF_LOTTONUM = 6;

    private Committee() {

    }

    public static Committee getInstance() {
        return committee;
    }

    public int[] calculateResult(List<Integer>[] issueNumbers, Lotto lotto, int bonusNumber) {
        int sameNumberCount[] = new int[ARRAY_SIZE];
        for (int i = 0; i < issueNumbers.length; i++) {
            int count = checkSameNumbers(issueNumbers, lotto, i);
            sameNumberCount[count]++;
            if (issueNumbers[i].contains(bonusNumber) && count == FIVE_INDEX) {
                sameNumberCount[BONUS_INDEX]++; //5개 일치, 보너스 볼 일치하는 경우
                sameNumberCount[FIVE_INDEX]--;
            }
        }
        return sameNumberCount;
    }

    private int checkSameNumbers(List<Integer>[] issueNumbers, Lotto lotto, int i) {
        int count = 0;
        for (int j = 0; j < NUM_OF_LOTTONUM; j++) {
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
        for (int i = 0; i < ARRAY_SIZE; i++) {
            sum += sameNumberCount[i] * prize[i];
        }
        rate = sum / (float) price * 100;
        return rate;
    }
}