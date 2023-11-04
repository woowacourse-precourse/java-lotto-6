package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    private static final String PURCAHSE_AMOUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_STATS_HEADER = "당첨 통계";
    private static final String DASH_LINE = "---";

    private static final String TOTAL_RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseAmount(int purchaseAmount){
        System.out.printf(PURCAHSE_AMOUNT_FORMAT,purchaseAmount);
    }

    public void printLottos(List<Lotto> lottos){
        lottos.forEach(lotto -> {
            lotto.sort();
            System.out.println(lotto +"\n");
        });
    }

    public void printTotalRateOfReturn(double rateOfReturn){
        System.out.printf(TOTAL_RATE_OF_RETURN_FORMAT,rateOfReturn);
    }
}
