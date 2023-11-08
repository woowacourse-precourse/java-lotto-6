package lotto.model;

import lotto.enumeration.WinningPrize;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private long winningCount;
    private double earningRate;
    private List<Integer> result;

    public LottoResult(Lottos lottos, WinningNumber winningNumber, UserAmount userAmount) {
        winningCount = 0;
        result = new ArrayList<>();

        initializeResult();
        insertResult(lottos, winningNumber);
        calculateEarningRate(userAmount);
    }

    private void insertResult(Lottos lottos, WinningNumber winningNumber) {
        for (Lotto lotto : lottos.getBundleLotto()) {
            List<Integer> numbers = lotto.getNumbers();
            winningCount = numbers.stream()
                    .filter(number -> winningNumber.contains(number))
                    .count();

            // 1등
            if (winningCount == WinningPrize.FIRST.getCount()) {
                result.add(0, result.get(0) + 1);
            }

            // 2등
            if (winningCount == WinningPrize.SECOND.getCount() && numbers.contains(winningNumber.getBonusNumber())) {
                result.add(1, result.get(1) + 1);
            }

            // 3,4,5등
            if (winningCount == WinningPrize.THIRD.getCount() && !numbers.contains(winningNumber.getBonusNumber())) {
                result.add(2, result.get(2) + 1);
            }

            if (winningCount == WinningPrize.FOURTH.getCount()) {
                result.add(3, result.get(3) + 1);
            }

            if (winningCount == WinningPrize.FIFTH.getCount()) {
                result.add(4, result.get(4) + 1);
            }
        }
    }

    private void initializeResult() {
        for(int i = 0; i < 5; i++) {
            result.add(0);
        }
    }

    public Integer getWinningResult(int place) {
        return result.get(place);
    }

    private void calculateEarningRate(UserAmount userAmount) {
        long sumEarning = 0;
        sumEarning += result.get(0) * 2000000000;
        sumEarning += result.get(1) * 30000000;
        sumEarning += result.get(2) * 1500000;
        sumEarning += result.get(3) * 50000;
        sumEarning += result.get(4) * 5000;

        earningRate = (double)sumEarning / userAmount.getAmount() * 100;
    }

    public double getEarningRate() {
        return earningRate;
    }


}
