package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.view.OutputMessage;

public class ResultGenerator {
    private final List<MatchScore> matchScores;
    private final Map<Ranking, Integer> rankingCounts;
    private final List<Ranking> printedRankings;
    private final int purchasePrice;

    public ResultGenerator(UserLotto userLotto, WinningLotto winningLotto, int purchasePrice) {
        this.matchScores = userLotto.calculateMatchScores(winningLotto);
        this.rankingCounts = new HashMap<>();
        this.printedRankings = getPrintedRankings();
        this.purchasePrice = purchasePrice;

        fillRankingCounts();
    }

    private void fillRankingCounts() {
        for (MatchScore matchScore : matchScores) {
            Ranking ranking = matchScore.getRanking();
            int rankingCount = rankingCounts.getOrDefault(ranking, 0);
            rankingCounts.put(ranking, rankingCount + 1);
        }
    }

    public String generate() {
        return generateRankingResult() + "\n" + generateWinningStatistics();
    }

    private String generateRankingResult() {
        List<String> rankingPhrases = new ArrayList<>();

        for (Ranking ranking : printedRankings) {
            String contents = ranking.getContents();
            int reward = ranking.getReward();
            int rankingCount = rankingCounts.getOrDefault(ranking, 0);

            rankingPhrases.add(
                    String.format(OutputMessage.WINNING_RESULT.getMessage(), contents, reward, rankingCount));
        }

        return String.join("\n", rankingPhrases);
    }

    private List<Ranking> getPrintedRankings() {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> !ranking.getContents().equals(""))
                .toList();
    }

    private String generateWinningStatistics() {
        int profit = 0;
        for (Ranking ranking : printedRankings) {
            int reward = ranking.getReward();
            int rankingCount = rankingCounts.getOrDefault(ranking, 0);
            profit += (reward * rankingCount);
        }

        return String.format(OutputMessage.WINNING_STATISTICS.getMessage(), (float) (profit * 100) / purchasePrice);
    }

}
