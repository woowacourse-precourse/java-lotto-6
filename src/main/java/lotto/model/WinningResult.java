package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningResult {
    private final Map<Integer, String> rankTable;
    private Map<String, Long> winningResult;

    public WinningResult() {
        this.rankTable = new HashMap<>();
        this.rankTable.put(Rule.FIRST_RANK.value(), "1st");
        this.rankTable.put(Rule.SECOND_RANK.value(), "2nd");
        this.rankTable.put(Rule.THIRD_RANK.value(), "3rd");
        this.rankTable.put(Rule.FOURTH_RANK.value(), "4th");
        this.rankTable.put(Rule.FIFTH_RANK.value(), "5th");
    }

    public Map<String, Long> getWinningResult() {
        return winningResult;
    }
환
    public void calculate(List<Integer> matchResult) {
        winningResult = matchResult.stream()
                .filter(number -> number >= Rule.MINIMUM_NUMBER_TO_WIN.value())
                .map(rankTable::get)
                .collect(Collectors.groupingBy(Function.identity(),  Collectors.counting()));
        makeGeneralForm(winningResult);
    }

    private void makeGeneralForm(Map<String, Long> winningResult) {
        List<String> ranks = List.of("1st", "2nd", "3rd", "4th", "5th");

        ranks.forEach(rank -> {
            winningResult.computeIfAbsent(rank, k -> Long.valueOf(0));
        });
    }

    public static int determineRankByBonus(int rank, boolean isBonusHit) {
        if (rank == Rule.THIRD_RANK.value() && isBonusHit)
            return Rule.SECOND_RANK.value();
        return rank;
    }
}
