package lotto.v3.view;

import lotto.v3.model.Lotto;

import java.util.List;

public class LottoGenerateView {

    public void displayLottoTickets(List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }
}
