package lotto.view;

import static lotto.util.ResultFormatter.formatResult;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinningRank;

public class OutputView {
    private enum ConsoleMessage {
        TICKET_NUMBER("\n%d개를 구매했습니다.\n"),
        GAME_RESULT_MESSAGE("\n당첨통계\n---");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }

    }
    public void printTicket(LottoTicket lottoTicket) {
        printTicketMain(lottoTicket.getTicketCount());
        printTicketList(lottoTicket);
    }

    private void printTicketMain(int ticketNumber) {
        System.out.printf(ConsoleMessage.TICKET_NUMBER.message, ticketNumber);
    }

    private void printTicketList(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottos()) {
            System.out.println(lotto.toString());
        }
    }

    public void printGameResult(Map<WinningRank, Integer> rankResult, BigDecimal resultRate) {
        System.out.println(ConsoleMessage.GAME_RESULT_MESSAGE.message);
        System.out.println(formatResult(rankResult, resultRate));
    }
}
