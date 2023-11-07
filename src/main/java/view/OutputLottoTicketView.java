package view;

import domain.Lotto;
import domain.LottoTicket;

public class OutputLottoTicketView {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String NEW_LINE = "\n";
    public static void printLottoTicket(LottoTicket lottoTicket) {
        int lottoTicketSize = lottoTicket.getLottoTicket().size();
        System.out.println(NEW_LINE + lottoTicketSize + PURCHASE_MESSAGE);

        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            System.out.println(lotto);
        }
    }
}
