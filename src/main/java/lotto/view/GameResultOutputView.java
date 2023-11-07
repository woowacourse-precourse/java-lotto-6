package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTicket;

public class GameResultOutputView {
    private static final String PURCHASED_COUNT_MESSAGE = "개를 구매했습니다.";

    public static void showLottoTickets(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.getLottoTicketCount() + PURCHASED_COUNT_MESSAGE);
        for (Lotto lotto : lottoTicket.getLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
