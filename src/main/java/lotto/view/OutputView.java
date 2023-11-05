package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningStatistics;

import java.util.List;

import static lotto.message.ResponseMessage.*;

public class OutputView {

    public void responseLottos(List<Lotto> lottos) {
        String boughtMessage = String.format(BOUGHT_MESSAGE, lottos.size());
        System.out.println(boughtMessage);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void responseWinningStatistics(WinningStatistics winningStatistics, Integer purchaseAmount){
        System.out.println(STATISTICS_MESSAGE + DIVISION_LINE);
        System.out.println(winningStatistics.toString()
                + winningStatistics.calculateRateOfReturn(purchaseAmount));
    }
}
