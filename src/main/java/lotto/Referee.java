package lotto;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private final int[] RIGHT = {5000, 50000, 1500000, 30000000, 2000000000};

    // [그외, 3, 4, 5, 5+1, 6]
    List<Integer> result = new ArrayList<>(6);


    public Referee() {
        for (int i = 0; i < 6; i++) {
            result.add(0);
        }
    }

    public void printResult(List<Lotto> lottos, Wining wining) {
        for (Lotto lotto:lottos) {
            List<Integer> numbers = lotto.getNumbers();

            boolean cb = checkBonus(numbers, wining.getBonus());

            numbers.retainAll(wining.getJackpot());
            int winCnt = numbers.size();
            int idx = calConclusion(winCnt, cb);
            result.set(idx, result.get(idx) + 1);
        }
    }

    private int calConclusion(int winCnt, boolean cb) {
        if (winCnt == 3) {
            return 1;
        }
        else if (winCnt == 4){
            return 2;
        }
        else if (winCnt == 5 && !cb){
            return 3;
        }
        else if (winCnt == 5 && cb){
            return 4;
        }
        else if (winCnt == 6) {
            return 5;
        }
        return 0;
    }

    private boolean checkBonus(List<Integer> numbers, Integer bonus) {
        return numbers.contains(bonus);
    }

    public int calculateRateOfReturn(int price) {
        int getMoney = 0;
        for (int i = 0; i < 6; i++) {
            getMoney += RIGHT[i] * result.get(i);
        }
        return Math.round(price/getMoney*100);
    }

}
