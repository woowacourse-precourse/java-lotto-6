package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void displayLottoTickets(List<Lotto> lottoTickets) {
        System.out.println("\n구매한 로또 티켓:");
        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }
}

