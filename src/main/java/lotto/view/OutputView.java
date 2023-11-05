package lotto.view;

import java.util.List;
import lotto.constants.Message;
import lotto.domain.Lotto;

public class OutputView {
    public void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.printf(Message.PURCHASE_AMOUNT.getMessage(), lottoTickets.size());
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }
}
