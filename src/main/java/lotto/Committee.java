package lotto;

import java.util.List;

public class Committee {
    private static Committee committee = new Committee();
    static final int NUM_OF_LOTTONUM = 6;

    private Committee() {

    }

    public static Committee getInstance() {
        return committee;
    }

    public void calculateResult(List<Integer>[] issueNumbers, Lotto lotto, int bonusNumber) {
        for (int i = 0; i < issueNumbers.length; i++) {
            int count = checkSameNumbers(issueNumbers, lotto, i);
            if (Result.getResult(count) != null) {
                Result.getResult(count).increaseCount();
            }
            if (issueNumbers[i].contains(bonusNumber) && count == Result.FIVE_BONUS.getNum()) {
                Result.FIVE_BONUS.increaseCount();
                Result.FIVE.decreaseCount();
            }
        }
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

    public float calculateRate(int price) {
        float rate = 0f;
        long sum = 0L;
        for (Result result : Result.values()) {
            sum += result.getCount() * result.getPrize();
        }
        rate = sum / (float) price * 100;
        return rate;
    }
}