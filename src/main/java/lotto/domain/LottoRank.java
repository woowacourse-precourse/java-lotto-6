package lotto.domain;

import java.util.HashMap;

public class LottoRank {

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    private double totalEarningRate;

    public void calculateRanking(WinningStatistics winningStatistics) {
        ranks(winningStatistics.getWinningStatistics(), winningStatistics.getBonusStatistics());
    }

    private void ranks(HashMap<Integer, Integer> winningStatistics, HashMap<Integer, Integer> bonusStatistics) {
        fifth = winningStatistics.get(3);
        fourth = winningStatistics.get(4);
        third = bonusStatistics.get(0);
        second = bonusStatistics.get(1);
        first = winningStatistics.get(6);
    }

    public String convertToString() {
        return Prize.FIFTH.getMessage() + fifth + Prize.UNIT.getMessage() + "\n" +
                Prize.FORTH.getMessage() + fourth + Prize.UNIT.getMessage() + "\n" +
                Prize.THIRD.getMessage() + third + Prize.UNIT.getMessage() + "\n" +
                Prize.SECOND.getMessage() + second + Prize.UNIT.getMessage() + "\n" +
                Prize.FIRST.getMessage() + first + Prize.UNIT.getMessage();
    }

    public String getTotalEarningRate(int amount) {
        calculateEarningRate(amount);
        return roundToSecondDecimalPlace();
    }

    private String roundToSecondDecimalPlace() {
        double roundedValue = Math.round(totalEarningRate * 100.0) / 100.0;
        return String.format("%.1f", roundedValue);
    }

    private void calculateEarningRate(int amount) {
        int purchaseAmount = amount * LottoConstants.THOUSAND.getValue();
        long sum = getSum();
        this.totalEarningRate = ((double) sum / purchaseAmount) * 100;
    }

    private long getSum() {
        long sum = 0;
        sum += first * Prize.FIRST.getMoney();
        sum += second * Prize.SECOND.getMoney();
        sum += third * Prize.THIRD.getMoney();
        sum += fourth * Prize.FORTH.getMoney();
        sum += fifth * Prize.FIFTH.getMoney();
        return sum;
    }


}
