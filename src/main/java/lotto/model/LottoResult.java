package lotto.model;

import lotto.enumeration.WinningPrize;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private static final int DIVISER = 100;
    private static final int INIT_VALUE = 0;

    private long winningCount;
    private double earningRate;
    private List<Integer> result;

    public LottoResult(Lottos lottos, WinningNumber winningNumber, UserAmount userAmount) {
        winningCount = INIT_VALUE;
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

            isFirst();
            isSecond(winningNumber, numbers);
            isThird(winningNumber, numbers);
            isFourth();
            isFifth();
        }
    }

    private void isFifth() {
        if (winningCount == WinningPrize.FIFTH.getCount()) {
            result.add(WinningPrize.FIFTH.getRank(), result.get(WinningPrize.FIFTH.getRank()) + 1);
        }
    }

    private void isFourth() {
        if (winningCount == WinningPrize.FOURTH.getCount()) {
            result.add(WinningPrize.FOURTH.getRank(), result.get(WinningPrize.FOURTH.getRank()) + 1);
        }
    }

    private void isThird(WinningNumber winningNumber, List<Integer> numbers) {
        if (winningCount == WinningPrize.THIRD.getCount() && !numbers.contains(winningNumber.getBonusNumber())) {
            result.add(WinningPrize.THIRD.getRank(), result.get(WinningPrize.THIRD.getRank()) + 1);
        }
    }

    private void isSecond(WinningNumber winningNumber, List<Integer> numbers) {
        if (winningCount == WinningPrize.SECOND.getCount() && numbers.contains(winningNumber.getBonusNumber())) {
            result.add(WinningPrize.SECOND.getRank(), result.get(WinningPrize.SECOND.getRank()) + 1);
        }
    }

    private void isFirst() {
        if (winningCount == WinningPrize.FIRST.getCount()) {
            result.add(WinningPrize.FIRST.getRank(), result.get(WinningPrize.FIRST.getRank()) + 1);
        }
    }

    private void initializeResult() {
        for(int i = INIT_VALUE; i <= WinningPrize.FIFTH.getRank(); i++) {
            result.add(INIT_VALUE);
        }
    }

    public int getWinningResult(int place) {
        return result.get(place);
    }

    private void calculateEarningRate(UserAmount userAmount) {
        long sumEarning = INIT_VALUE;
        sumEarning += result.get(WinningPrize.FIRST.getRank()) * WinningPrize.FIRST.getPrize();
        sumEarning += result.get(WinningPrize.SECOND.getRank()) * WinningPrize.SECOND.getPrize();
        sumEarning += result.get(WinningPrize.THIRD.getRank()) * WinningPrize.THIRD.getPrize();
        sumEarning += result.get(WinningPrize.FOURTH.getRank()) * WinningPrize.FOURTH.getPrize();
        sumEarning += result.get(WinningPrize.FIFTH.getRank()) * WinningPrize.FIFTH.getPrize();

        earningRate = (double)sumEarning / userAmount.getAmount() * DIVISER;
    }

    public double getEarningRate() {
        return earningRate;
    }


}
