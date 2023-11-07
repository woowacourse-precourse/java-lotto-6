package lotto.domain.game;

import lotto.global.constant.LottoRank;

import java.util.List;
import java.util.Map;

import static lotto.global.constant.LottoRank.*;

public class WinningResultGenerator {
    private static final String RESULT_FORMAT = "%s - %s개";
    private static final String NEXT_LINE = "\n";
    private static final List<LottoRank> lottoRanks
            = List.of(FIFTH_PLACE, FOURTH_PLACE, THIRD_PLACE, SECOND_PLACE, FIRST_PLACE);

    public static String generateWinningResults(Map<LottoRank, Integer> rankMap) {
        StringBuilder resultMessage = new StringBuilder();

        for (LottoRank lottoRank : lottoRanks) {
            String result = generateWinningResultOfOneRank(rankMap, lottoRank);
            resultMessage.append(result).append(NEXT_LINE);
        }
        return resultMessage.toString();
    }

    private static String generateWinningResultOfOneRank(Map<LottoRank, Integer> rankMap, LottoRank lottoRank) {
        String message = lottoRank.getMessage();
        int rankCount = rankMap.getOrDefault(lottoRank, 0);

        return String.format(RESULT_FORMAT, message, rankCount);
    }
}
