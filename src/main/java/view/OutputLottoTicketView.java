package view;

import domain.Lotto;
import domain.LottoTicket;

public class OutputLottoTicketView {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static void printLottoTicket(LottoTicket lottoTicket) {
        int lottoTicketSize = lottoTicket.getLottoTicket().size();
        System.out.println(lottoTicketSize + PURCHASE_MESSAGE);

        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            System.out.println(lotto);
        }
    }
}
