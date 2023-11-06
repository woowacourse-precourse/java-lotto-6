package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String OUT_LINE = "---";

    public static void printMyLotto(Lottos lottos) {
        System.out.println(getWinningResultMessage(lottos.getLottoCount()));
        printLottoList(lottos);
    }

    private static void printLottoList(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printWinningStatistics(LottoResult lottoResult) {
        System.out.println(ViewMessage.OUTPUT_WINNING_STATISTICS.getMessage());
        System.out.println(OUT_LINE);
        for (Map.Entry<Rank, Integer> entry : lottoResult.getSortedResultList()) {
            if (entry.getKey() != Rank.MISS) {
                System.out.println(ViewMessage.getWinningResultMessage(entry.getKey(), entry.getValue()));
            }
        }
    }

    private static String getWinningResultMessage(int count) {
        return ViewMessage.OUTPUT_PURCHASED_LOTTOS.getPurchasedLottosMessage(count);
    }
}
