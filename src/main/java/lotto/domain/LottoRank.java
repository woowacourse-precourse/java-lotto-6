package lotto.domain;

import java.util.HashMap;

public class LottoRank {

    private static final double HUNDRED_POINT_ZERO = 100.0;
    private static final String FORMAT_ONE_DECIMAL = "%.1f";
    private static final String FORMAT_COMMA = "%,d";
    private static final String REGEX_DOT = "\\.";
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
        double roundedValue = Math.round(totalEarningRate * HUNDRED_POINT_ZERO) / HUNDRED_POINT_ZERO;
        String[] parts = insertComma(roundedValue);
        return String.join(".", parts);
    }

    private static String[] insertComma(double roundedValue) {
        String formattedValue = String.format(FORMAT_ONE_DECIMAL, roundedValue);
        String[] parts = formattedValue.split(REGEX_DOT);
        parts[0] = String.format(FORMAT_COMMA, Long.parseLong(parts[0]));
        return parts;
    }

    private void calculateEarningRate(int amount) {
        int purchaseAmount = amount * LottoConstants.THOUSAND.getValue();
        long sum = getSum();
        this.totalEarningRate = ((double) sum / purchaseAmount) * LottoConstants.HUNDRED.getValue();
    }

    private long getSum() {
        long sum = LottoConstants.ZERO.getValue();
        sum += first * Prize.FIRST.getMoney();
        sum += second * Prize.SECOND.getMoney();
        sum += third * Prize.THIRD.getMoney();
        sum += fourth * Prize.FORTH.getMoney();
        sum += fifth * Prize.FIFTH.getMoney();
        return sum;
    }
}
