package lotto.view;

import lotto.constant.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoGameResult;

import javax.swing.plaf.IconUIResource;
import java.util.List;

import static lotto.constant.ConsoleMessage.LOTTO_PROFIT_RATE;
import static lotto.constant.ConsoleMessage.LOTTO_PURCHASE_COMPLETED;
import static lotto.constant.ConsoleMessage.LOTTO_RESULT_FORMAT;
import static lotto.constant.ConsoleMessage.LOTTO_SECOND_RANK_RESULT_FORMAT;

public class OutputView {

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf((LOTTO_PURCHASE_COMPLETED), lottos.size());

        lottos.forEach(System.out::println);
    }

    public void printLottoResult(LottoGameResult result) {
        printLottoResultHeader();

        List<LottoRank> lottoRanks = LottoRank.getLottoRanksExceptNoLuck();
        for (LottoRank rank : lottoRanks) {
            if (rank == LottoRank.SECOND) {
                System.out.printf(LOTTO_SECOND_RANK_RESULT_FORMAT
                        , rank.getSameCount(), rank.getRewardMoneyFormat(), result.getCountOfRank(rank));
                continue;
            }
            System.out.printf(LOTTO_RESULT_FORMAT
                    , rank.getSameCount(), rank.getRewardMoneyFormat(), result.getCountOfRank(rank));
        }

        printLottoProfitRate(result.calculateProfitRate());
    }

    private void printLottoResultHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void printLottoProfitRate(double profitRate) {
        System.out.printf((LOTTO_PROFIT_RATE), profitRate);
    }
}
