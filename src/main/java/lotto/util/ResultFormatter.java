package lotto.util;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import lotto.domain.LottoRank;

public class ResultFormatter {
    private static final String MATCH_FORMAT = "%d개 일치%s (%s원) - %d개\n";
    private static final String BONUS_PART = ", 보너스 볼 일치";
    private static final String NONE = "NONE";
    private static final String EMPTY = "";
    private static final String PRIZE_FORMAT = "%,d";
    private static final int ZERO = 0;


    public String createWinningStatistics(LinkedHashMap<LottoRank, Integer> winnerCount) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> !rank.name().equals(NONE))
                .map(rank -> createRankMessage(rank, winnerCount.getOrDefault(rank, ZERO)))
                .collect(Collectors.joining());
    }

    private String createRankMessage(LottoRank rank, int count) {
        String bonusPart = EMPTY;
        if (rank.isMatchBonus()) {
            bonusPart = BONUS_PART;
        }
        return String.format(MATCH_FORMAT,
                rank.getMatchCount(),
                bonusPart,
                String.format(PRIZE_FORMAT, rank.getPrize()),
                count);
    }

}
