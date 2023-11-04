package lotto.view.output;

import lotto.domain.lotto.LottoRank;
import lotto.message.LottoResultMessage;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class LottoResultOutputView {

    public void printWinningStatisticsStartMessage() {
        System.out.println(LottoResultMessage.WINNING_STATISTICS.getMessage());
    }

    public void printDashLine() {
        System.out.println(LottoResultMessage.DASH_LINE.getMessage());
    }

    public void printLottoAllMatch(Map<LottoRank, Long> lottoRankCountMap) {
        Set<LottoRank> lottoRanks = lottoRankCountMap.keySet();
        lottoRanks.stream()
                .forEach(lottoRank -> lottoRank.accept(lottoRankCountMap.get(lottoRank)));
    }

}
