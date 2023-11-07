package lotto.manager;

import lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.utility.StringUtil.PRINT_PROFIT;
import static lotto.utility.StringUtil.PRINT_WINNING_DETAILS;

public class StatisticsManager {

    private static StatisticsManager statisticsManager;
    private final Map<Integer, Integer> countByMatchNumber;
    private final Map<Integer, Integer> priceByMatchNumber;
    private int payAmount;
    private List<Lotto> lottos;
    private List<Integer> winningNumber;
    private int bonusNumber;
    private double profit;

    private StatisticsManager() {
        countByMatchNumber = new HashMap<>();
        countByMatchNumber.put(3, 0);
        countByMatchNumber.put(4, 0);
        countByMatchNumber.put(5, 0);
        countByMatchNumber.put(51, 0);
        countByMatchNumber.put(6, 0);

        priceByMatchNumber = new HashMap<>();
        priceByMatchNumber.put(3, 5000);
        priceByMatchNumber.put(4, 50000);
        priceByMatchNumber.put(5, 1500000);
        priceByMatchNumber.put(51, 30000000);
        priceByMatchNumber.put(6, 2000000000);
    }

    public static StatisticsManager getInstance() {
        if ( statisticsManager == null ) {
            statisticsManager = new StatisticsManager();
        }
        return statisticsManager;
    }

    public void calculateAllStatistics() {
        for (Lotto lotto : lottos) {
            calculateLottoStatistics(lotto);
        }
    }

    public void calculateLottoStatistics(Lotto lotto) {
        int matchCount = 0;
        int bonusCount = 0;

        for (int number : lotto.getNumbers()) {
            if (winningNumber.contains(number)) {
                matchCount++;
            }

            if (bonusNumber == number) {
                bonusCount++;
            }
        }

        countIntegrate(matchCount, bonusCount);
    }

    public void countIntegrate(int winningCount, int bonusCount) {
        int joinWinAndBonus = Integer.parseInt(Integer.toString(winningCount) + Integer.toString(bonusCount));

        if (countByMatchNumber.containsKey(joinWinAndBonus)) {
            int oldCount = countByMatchNumber.get(joinWinAndBonus);
            countByMatchNumber.put(joinWinAndBonus, oldCount + 1);
        }

        if (!countByMatchNumber.containsKey(joinWinAndBonus) &&
                countByMatchNumber.containsKey(winningCount)) {
            int oldCount = countByMatchNumber.get(winningCount);
            countByMatchNumber.put(winningCount, oldCount + 1);
        }
    }

    public void calculateProfit() {
        double totalPrice = 0.0;

        for ( int matchNumber : countByMatchNumber.keySet() ) {
            totalPrice += priceByMatchNumber.get(matchNumber) * countByMatchNumber.get(matchNumber);
        }

        profit = (Math.round((totalPrice / (double) payAmount) * 10) / 10.0);
    }

    public void printProfit() {
        System.out.printf(PRINT_PROFIT.getMessage(), profit);
    }

    public void printWinningStatistics() {
        System.out.printf(PRINT_WINNING_DETAILS.getMessage(), "3개 일치", "5,000", countByMatchNumber.get(3));
        System.out.printf(PRINT_WINNING_DETAILS.getMessage(), "4개 일치", "50,000", countByMatchNumber.get(4));
        System.out.printf(PRINT_WINNING_DETAILS.getMessage(), "5개 일치", "1,500,000", countByMatchNumber.get(5));
        System.out.printf(PRINT_WINNING_DETAILS.getMessage(), "5개 일치, 보너스 볼 일치", "30,000,000", countByMatchNumber.get(51));
        System.out.printf(PRINT_WINNING_DETAILS.getMessage(), "6개 일치", "2,000,000,000", countByMatchNumber.get(6));
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
