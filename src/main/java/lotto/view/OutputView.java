package lotto.view;

import lotto.constant.LottoRank;
import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String COUNTS_OF_PURCHASING_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";
    private static final String WINNING_RATE_MESSAGE_PREFIX = "총 수익률은 ";
    private static final String WINNING_RATE_MESSAGE_SUFFIX = "%입니다.";

    public void printCountsOfPurchasing(int counts) {
        System.out.println(counts + COUNTS_OF_PURCHASING_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printRankCounts(HashMap<LottoRank, Integer> rankCounter) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(getCountsMessage(rankCounter, LottoRank.FIFTH_PRIZE));
        System.out.println(getCountsMessage(rankCounter, LottoRank.FOURTH_PRIZE));
        System.out.println(getCountsMessage(rankCounter, LottoRank.THIRD_PRIZE));
        System.out.println(getCountsMessage(rankCounter, LottoRank.SECOND_PRIZE));
        System.out.println(getCountsMessage(rankCounter, LottoRank.FIRST_PRIZE));
    }

    private String getCountsMessage(HashMap<LottoRank, Integer> rankCounter, LottoRank lottoRank) {
        return lottoRank.getMessageWith(rankCounter.get(lottoRank));
    }

    public void printWinningRate(double winningRate) {
        System.out.println(WINNING_RATE_MESSAGE_PREFIX + String.format("%.1f", winningRate)
                + WINNING_RATE_MESSAGE_SUFFIX);
    }
}
