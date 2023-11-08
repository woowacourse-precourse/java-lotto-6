package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.Result;

import java.util.List;

public class OutputView {
    public void printInputMessage() {
        System.out.println(LottoMessage.PURCHASE_MONEY_INPUT);
    }

    public void printIssuedLottoCount(List<Lotto> lottoBundle) {
        Integer lottoCount = lottoBundle.size();
        String purchaseLottoCountMessage = String.format(LottoMessage.PURCHASED_LOTTO_COUNT.toString(), lottoCount);
        System.out.println(purchaseLottoCountMessage);
    }

    public void printIssuedLottoBundle(List<Lotto> lottoBundle) {
        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.toString());
        }
    }

    public void printLottoResult(Result lottoResult, Double earningRatio) {
        String roundedEarningRatio = roundToTwoDecimalPlaces(earningRatio);

        System.out.printf(LottoMessage.PRINT_LOTTO_RESULT.toString(),
                lottoResult.getCountByRanking(Ranking.FIFTH),
                lottoResult.getCountByRanking(Ranking.FOURTH),
                lottoResult.getCountByRanking(Ranking.THIRD),
                lottoResult.getCountByRanking(Ranking.SECOND),
                lottoResult.getCountByRanking(Ranking.FIRST),
                roundedEarningRatio
        );
    }

    private String roundToTwoDecimalPlaces(Double earningRatio) {
        return String.format("%.1f", earningRatio);
    }
}
