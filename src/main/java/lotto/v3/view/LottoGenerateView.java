package lotto.v3.view;

import lotto.v3.model.Lotto;

import java.util.List;

public class LottoGenerateView {

    public void displayLottoTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }
}
