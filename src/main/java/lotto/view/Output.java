package lotto.view;

import lotto.constant.OutputMessage;
import lotto.model.LottoTicket;
import lotto.model.Order;
import lotto.model.WinStatistics;

public class Output {
    public void buyLottoNumbers(LottoTicket lottoTicket, Order order) {
        System.out.print(order.getBuyCountToString());
        System.out.println(OutputMessage.PURCHASED_COUNT_MESSAGE);

        // 구매한 티켓 번호 출력
    }

    public void printProfitRate(Order order, WinStatistics winStatistics) {

    }

    public void winStatistics(WinStatistics winStatistics) {
        System.out.println(OutputMessage.WINNING_STATISTICS_TITLE);
        // 등수별 개수 출력
    }

}
