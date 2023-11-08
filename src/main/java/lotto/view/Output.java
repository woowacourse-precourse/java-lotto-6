package lotto.view;

import lotto.constant.OutputMessage;
import lotto.model.LottoTicket;
import lotto.model.Order;
import lotto.model.WinStatistics;

public class Output {
    public void buyLottoNumbers(LottoTicket lottoTicket, Order order) {
        System.out.print(order.getBuyCountToString());
        System.out.println(OutputMessage.PURCHASED_COUNT_MESSAGE);

        System.out.println(lottoTicket.printResult());
    }

    public void printProfitRate(Order order, WinStatistics winStatistics) {
        System.out.println(order.getResult(winStatistics));
    }

    public void winStatistics(WinStatistics winStatistics) {
        System.out.println(OutputMessage.WINNING_STATISTICS_TITLE);
        System.out.println(winStatistics.printResult());
    }

}
