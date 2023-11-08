package lotto.calculator;

import java.util.ArrayList;
import java.util.List;
import lotto.WinningPrize;

public class PrizeCalculator {

    private List<WinningPrize> prizes = new ArrayList<>();
    private List<Integer> winningCount = new ArrayList<>();
    private List<Integer> bonusCount = new ArrayList<>();

    public PrizeCalculator(List<Integer> winningCount, List<Integer> bonusCount) {
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;

        calculatePrize();
    }

    // List<WinningPrize> prizes 를 받았어...
    public void calculatePrize() {

        for (int i=0; i<winningCount.size(); i++) {
            countMatchingNumbers(i);
        }
    }

    private void countMatchingNumbers(int i) {
        //winningCount 가 5가 아닐 때
        if (noNeedBonusCount(i)) {
            return;
        }
        //winningCount 가 5 일 때
        needBonusCount(i);
    }

    private void needBonusCount(int i) {
        if (bonusCount.get(i) == 1) {
            WinningPrize winningPrize = WinningPrize.FIFTH_PLACE;
            prizes.add(winningPrize);
            return;
        }
        WinningPrize winningPrize = WinningPrize.FOURTH_PLACE;
        prizes.add(winningPrize);
    }

    private boolean noNeedBonusCount (int i) {

        if (winningCount.get(i) < 3) {
            return true;
        }
        if (winningCount.get(i) != 5) {
            WinningPrize winningPrize = WinningPrize.findByCount(winningCount.get(i));
            prizes.add(winningPrize);
            return true;
        }
        return false;
    }

    public List<WinningPrize> getPrizes() {
        return prizes;
    }
}
