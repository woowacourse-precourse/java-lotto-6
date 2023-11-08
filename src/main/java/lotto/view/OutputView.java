package lotto.view;

import java.util.List;
import java.util.Map;

import lotto.message.OutMessage;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;
import lotto.service.LottoService;

public class OutputView {

    private static final String FIFTH_FORMAT = "3개 일치 (5,000원) - %s개";
    private static final String FOURTH_FORMAT = "4개 일치 (50,000원) - %s개";
    private static final String THIRD_FORMAT = "5개 일치 (1,500,000원) - %s개";
    private static final String SECOND_FORMAT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %s개";
    private static final String FIRST_FORMAT = "6개 일치 (2,000,000,000원) - %s개";

    public void printNumberOfLotto(List<Lotto> lottos) {
        System.out.println(String.format(OutMessage.OUT_NUMBER_OF_LOTTO.getMessage(), lottos.size()));
        for (var lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStatics(LottoResult lottoResult) {
        System.out.println(OutMessage.OUT_WINNING_STATISTICS);
        System.out.println(String.format(FIFTH_FORMAT, lottoResult.getRankCount(Rank.FIFTH)));
        System.out.println(String.format(FOURTH_FORMAT, lottoResult.getRankCount(Rank.FOURTH)));
        System.out.println(String.format(THIRD_FORMAT, lottoResult.getRankCount(Rank.THIRD)));
        System.out.println(String.format(SECOND_FORMAT, lottoResult.getRankCount(Rank.SECOND)));
        System.out.println(String.format(FIRST_FORMAT, lottoResult.getRankCount(Rank.FIRST)));
    }


    public void printTotalReturn(LottoResult lottoResult) {
        double totalReturn = LottoService.getTotalReturn(lottoResult);
        System.out.println(String.format(OutMessage.OUT_TOTAL_RETURN.getMessage(),totalReturn));
    }
}
