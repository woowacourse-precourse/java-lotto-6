package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Ranking;
import lotto.ui.message.OutputMessage;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void print(OutputMessage outputMessage) {
        System.out.println(outputMessage.getComment());
    }

    public void printLottoCount(Integer lottoCount) {
        System.out.println("" + lottoCount + OutputMessage.PRINT_LOTTO_COUNT.getComment());
    }

    //TODO: getter사용 고민해보기
    public void printLottoBundle(List<Lotto> lottoBundle) {
        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResult(LottoResult lottoResult, Double earningRatio) {
        String roundedEarningRatio = roundToTwoDecimalPlaces(earningRatio);

        System.out.printf(OutputMessage.PRINT_LOTTO_RESULT.getComment(),
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
