package lotto.model;

import java.util.SortedMap;
import java.util.TreeMap;

import lotto.constant.OutputMessage;

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
        return winStatistics.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getMoney() * entry.getValue())
                .sum();
    }

    public String printResult() {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(getFifthStatistics())
                .append(getFourthStatistics())
                .append(getThirdStatistics())
                .append(getSecondStatistics())
                .append(getFirstStatistics())
                .toString();
    }

    private String getFifthStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(OutputMessage.THREE_MATCH_PRIZE)
                .append(winStatistics.get(Rank.FIFTH))
                .append(OutputMessage.COUNT_SUFFIX)
                .toString();
    }

    private String getFourthStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(OutputMessage.FOUR_MATCH_PRIZE)
                .append(winStatistics.get(Rank.FOURTH))
                .append(OutputMessage.COUNT_SUFFIX)
                .toString();
    }

    private String getThirdStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(OutputMessage.FIVE_MATCH_PRIZE)
                .append(winStatistics.get(Rank.THIRD))
                .append(OutputMessage.COUNT_SUFFIX)
                .toString();
    }

    private String getSecondStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(OutputMessage.FIVE_MATCH_BONUS_PRIZE)
                .append(winStatistics.get(Rank.SECOND))
                .append(OutputMessage.COUNT_SUFFIX)
                .toString();
    }

    private String getFirstStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(OutputMessage.SIX_MATCH_PRIZE)
                .append(winStatistics.get(Rank.FIRST))
                .append(OutputMessage.COUNT_SUFFIX)
                .toString();
    }
}
