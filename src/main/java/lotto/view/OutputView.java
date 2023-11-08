package lotto.view;

import lotto.enums.OutputMsg;
import lotto.enums.StatisticsInfo;
import lotto.model.Lotto;
import lotto.model.Statistics;

import java.util.List;

public class OutputView {
    public void printPurchaseQuantity(int quantity) {
        System.out.printf(OutputMsg.PURCHASE_QUANTITY.getMsg(), quantity);
        System.out.println();
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void winningStatistics(Statistics statistics) {
        System.out.println(OutputMsg.RESULT.getMsg());
        System.out.println(OutputMsg.RESULT_LINE.getMsg());
        printWinning(statistics);
        printProfit(statistics.getProfit());
    }

    private void printWinning(Statistics statistics) {
        for (StatisticsInfo statisticsInfo : StatisticsInfo.values()) {
            System.out.printf(statisticsInfo.getMsg(), statistics.getCount(statisticsInfo.getRank()));
            System.out.println();
        }
    }

    private void printProfit(double profit) {
        System.out.printf((OutputMsg.PROFIT.getMsg()), profit);
    }
}
