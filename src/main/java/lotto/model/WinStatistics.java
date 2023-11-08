package lotto.model;

import java.util.SortedMap;
import java.util.TreeMap;

public class WinStatistics {
    private SortedMap<Rank, Integer> winStatistics;

    public WinStatistics() {
        winStatistics = new TreeMap<>();
        winStatistics.put(Rank.MISS, 0);
        winStatistics.put(Rank.FIFTH, 0);
        winStatistics.put(Rank.FOURTH, 0);
        winStatistics.put(Rank.THIRD, 0);
        winStatistics.put(Rank.SECOND, 0);
        winStatistics.put(Rank.FIRST, 0);
    }

    public void pushRank(Rank rank) {
        winStatistics.put(rank, winStatistics.get(rank) + 1);
    }

    public double sum() {
        double totalMoney = 0;
        for (Rank rank : this.winStatistics.keySet()) {
            totalMoney += rank.getMoney() * winStatistics.get(rank);
        }

        return totalMoney;
    }

    public String printResult() {

    }

    private String getFifthStatistics() {

    }

    private String getFourthStatistics() {

    }

    private String getThirdStatistics() {

    }

    private String getSecondStatistics() {

    }

    private String getFirstStatistics() {

    }
}
