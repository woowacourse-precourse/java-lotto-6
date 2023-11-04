package lotto.util;

import java.util.LinkedHashMap;
import lotto.domain.LottoRank;

public class ResultFormatter {
    private static final String MATCH_FORMAT = "%d개 일치%s (%s원) - %d개\n";
    private static final String BONUS_PART = ", 보너스 볼 일치";
    private static final String NONE = "NONE";

    public String createWinningStatistics(LinkedHashMap<LottoRank, Integer> winnerCount) {
        StringBuilder statisticsBuilder = new StringBuilder();
        for (LottoRank rank : LottoRank.values()) {
            if (rank.name().equals(NONE)) {
                continue;
            }
            statisticsBuilder.append(createRankMessage(rank, winnerCount.getOrDefault(rank, 0)));
        }
        return statisticsBuilder.toString();
    }

    private String createRankMessage(LottoRank rank, int count) {
        String bonusPart = "";
        if (rank.isMatchBonus()) {
            bonusPart = BONUS_PART;
        }
        return String.format(MATCH_FORMAT,
                rank.getMatchCount(),
                bonusPart,
                String.format("%,d", rank.getPrize()),
                count);
    }
}
